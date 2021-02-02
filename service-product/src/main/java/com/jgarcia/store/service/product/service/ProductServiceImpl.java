package com.jgarcia.store.service.product.service;

import com.jgarcia.store.service.product.entity.Category;
import com.jgarcia.store.service.product.entity.Product;
import com.jgarcia.store.service.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository  productRepository;

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreatedDate(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product dbProduct = productRepository.findById(product.getId()).orElse(null);
        if (null != dbProduct) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product dbProduct = productRepository.findById(productId).orElse(null);
        if (null != dbProduct) {
            dbProduct.setStatus("DELETED");
            productRepository.save(dbProduct);
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long productId, Double units) {
        Product dbProduct = getProduct(productId);
        if (null == dbProduct) {
            return null;
        }
        dbProduct.setStock(dbProduct.getStock() + units);
        return productRepository.save(dbProduct);
    }
}
