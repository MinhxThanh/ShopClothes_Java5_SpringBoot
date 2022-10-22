package edu.home.service;

import edu.home.model.CategoriesInProduct;
import edu.home.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    List<Category> findAllCategoriesByProductID(Integer id);

}
