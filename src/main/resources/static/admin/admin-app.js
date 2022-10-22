const app = angular.module('adminApp', ['ngRoute'])
app.config(function ($routeProvider){
    $routeProvider
        .when("/product", {
            templateUrl: "/admin/product/index.html?"  + Math.random(),
            controller: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/admin/authority/index.html?"  + Math.random(),
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/admin/authority/unauthorized.html?"  + Math.random(),
            controller: "authority-ctrl"
        })
        .when("/images", {
            templateUrl: "/admin/image/index.html?"  + Math.random(),
            controller: "images-ctrl"
        })
        .otherwise({
            template: "<h2 class='test-center'>Welcome To Adminnistration Page </h2>"
        })
})

