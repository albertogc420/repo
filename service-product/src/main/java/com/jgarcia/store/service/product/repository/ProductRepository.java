package com.jgarcia.store.service.product.repository;

import com.jgarcia.store.service.product.entity.Category;
import com.jgarcia.store.service.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByCategory(Category category);
}
