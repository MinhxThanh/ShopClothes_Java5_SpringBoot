package edu.home.service;

import edu.home.model.Category;
import edu.home.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryName(String s);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

    List<Product> findAllProductByCategories(String categoryName);
}
