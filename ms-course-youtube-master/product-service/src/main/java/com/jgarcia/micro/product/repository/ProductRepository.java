package com.jgarcia.micro.product.repository;

import com.jgarcia.micro.product.entity.Category;
import com.jgarcia.micro.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
