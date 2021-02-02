package com.jgarcia.store.service.product.controller;

import com.jgarcia.store.service.product.entity.Category;
import com.jgarcia.store.service.product.entity.Product;
import com.jgarcia.store.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.listAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreated = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.OK).body(productCreated);
    }

    @GetMapping(value = "/category/{idCategory}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("idCategory") Long idCategory) {
        List<Product> products = productService.findByCategory(Category.builder().id(idCategory).build());

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping(value = "/{idProduct}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("idProduct") Long idProduct) {
        Product storedProduct = productService.getProduct(idProduct);
        if (null == storedProduct) {
            return ResponseEntity.notFound().build();
        }
        storedProduct.setStatus("REMOVED");
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(storedProduct));
    }

    @PutMapping(value = "/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable("idProduct") Long idProduct, @RequestBody @Valid Product product) throws CloneNotSupportedException {
        Product storedProduct = productService.getProduct(idProduct);
        if (null == storedProduct) {
            return ResponseEntity.notFound().build();
        }

        storedProduct = (Product) product.clone();
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(storedProduct));
    }


}
