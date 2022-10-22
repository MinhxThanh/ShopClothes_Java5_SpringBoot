package edu.home.service.impl;

import edu.home.model.Category;
import edu.home.model.Product;
import edu.home.repository.ProductRepository;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryName(String s) {
        return dao.findByCategoryNameLike(s);
    }

    @Override
    public Product create(Product product) {
        return dao.save(product);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Product> findAllProductByCategories(String categoryName) {
        return dao.findByCategoryNameLike(categoryName);
    }


}
