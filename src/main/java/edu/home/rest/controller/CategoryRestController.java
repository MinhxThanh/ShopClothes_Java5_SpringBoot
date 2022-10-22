package edu.home.rest.controller;

import edu.home.model.Category;
import edu.home.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "categories")
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "categories/getAllCategoriesByProductID/{id}")
    public List<Category> getAllCategoriesByProductID(@PathVariable("id") Integer id) {
        return categoryService.findAllCategoriesByProductID(id);
    }
}
