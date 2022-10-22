package edu.home.repository;

import edu.home.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("select c from Category c join CategoriesInProduct cp on cp.category.id = c.id " +
            "join Product p on p.id = cp.product.id where p.id = ?1")
    List<Category> findAllCategoriesByProductId(Integer id);
}