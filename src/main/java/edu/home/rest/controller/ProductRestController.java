package edu.home.rest.controller;

import edu.home.model.Category;
import edu.home.model.Product;
import edu.home.service.CategoryService;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "products")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping(value = "products/getAllByCategories/{id}")
    public List<Product> getAllByCategories(@PathVariable("id") Integer id){
        List<Category> categories =categoryService.findAllCategoriesByProductID(id);
        String categoryName = categories.stream().findFirst().get().getName();
        return productService.findAllProductByCategories(categoryName);
    }

    @GetMapping(value = "products/{id}")
    public Product getByID(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @PostMapping(value = "products")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping(value = "products/{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping(value = "products/{id}")
    public void delete(@PathVariable("id") Integer id){
         productService.delete(id);
    }
}
