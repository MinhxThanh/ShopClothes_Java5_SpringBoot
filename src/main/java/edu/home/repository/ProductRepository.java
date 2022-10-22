package edu.home.repository;

import edu.home.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p left join CategoriesInProduct cp on cp.product.id = p.id left join Category c on c.id = cp.category.id where c.name = ?1")
    List<Product> findByCategoryNameLike(String name);
}