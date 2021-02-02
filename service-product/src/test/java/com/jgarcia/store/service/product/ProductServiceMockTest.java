package com.jgarcia.store.service.product;


import com.jgarcia.store.service.product.repository.ProductRepository;
import com.jgarcia.store.service.product.service.ProductService;
import com.jgarcia.store.service.product.service.ProductServiceImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    ProductRepository productRepository;

    ProductService productService;

    void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

}
