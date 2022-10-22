const app = angular.module("shopping-cart-app", [])
app.controller("shopping-cart-controller", function ($scope, $http) {
    $scope.inputQuantityItem = 1
    $scope.listProductsByCategory = []

    $scope.findByProductID = function (id){
        $http.get(`/rest/products/getAllByCategories/${id}`).then(resp =>{
            $scope.listProductsByCategory = resp.data
            console.log("listProductsByCategory", resp.data)
        }).catch(err =>{
            console.log("listProductsByCategory Error", err)
        })
    }

    $scope.pager = {
        page: 0,
        size: 4,
        get count(){
            return Math.ceil(1.0 * $scope.listProductsByCategory.length / this.size)
        },
        get length(){
            return $scope.listProductsByCategory.length
        },
        prev(){
            this.page--
            if (this.page < 0)
                this.page = this.count - 1
        },
        next(){
            this.page++
            if (this.page >= this.count)
                this.page = 0
        }
    }

    $scope.productQuantityDown = function (){
        if ($scope.inputQuantityItem > 1)
            $scope.inputQuantityItem--
    }
    $scope.productQuantityUp = function () {
        $scope.inputQuantityItem++
    }

    $scope.cart = {
        items: [],
        add(id){
            console.log("inputQuantityItem", $scope.inputQuantityItem)
            let item = this.items.find(item => item.id == id)
            if (item){
                item.quantity += $scope.inputQuantityItem
                this.saveToLocalStorage();
            }else {
                $http.get(`/rest/products/${id}`).then(resp =>{
                    resp.data.quantity = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                    console.log(this)
                })
            }
        },
        delete(id){
            let index = this.items.findIndex(item => item.id == id)
            this.items.splice(index, 1)
            this.saveToLocalStorage()
        },
        clear(){
          this.items = []
            this.saveToLocalStorage()
        },
        get count(){
            return this.items
                .map(item => item.quantity)
                .reduce((total, quantity) => total += quantity, 0)
        },
        get amount(){
            return this.items
                .map(item => item.quantity*item.price)
                .reduce((total, quantity) => total += quantity, 0)
        },
        saveToLocalStorage(){
            let json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage(){
            let json = localStorage.getItem("cart")
            this.items = json ? JSON.parse(json) : []
        }
    }
    $scope.cart.loadFromLocalStorage()

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {username: ""},
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return {
                    product:{id: item.id},
                    price: item.price,
                    quantity: item.quantity
                }
            })
        },
        purchase(){
            let order = angular.copy(this)
            $http.post("/rest/orders", order).then(resp =>{
                $scope.cart.clear()
                location.href = "/order/detail/" + resp.data.id
            }).catch(error =>{
                console.log("Error", error)
            })
        }
    }

})