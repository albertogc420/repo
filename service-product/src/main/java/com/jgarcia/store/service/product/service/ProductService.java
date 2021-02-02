package com.jgarcia.store.service.product.service;

import com.jgarcia.store.service.product.entity.Category;
import com.jgarcia.store.service.product.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProduct(Long productId);
    Product createProduct(Product p);
    Product updateProduct(Product product);
    void deleteProduct(Long productId);
    List<Product> findByCategory(Category category);
    Product updateStock(Long productId,Double stock);


}
