package edu.home.service.impl;

import edu.home.model.Category;
import edu.home.repository.CategoryRepository;
import edu.home.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository dao;
    @Override
    public List<Category> findAll() {
       return dao.findAll();
    }

    @Override
    public List<Category> findAllCategoriesByProductID(Integer id) {
        return dao.findAllCategoriesByProductId(id);
    }

}
