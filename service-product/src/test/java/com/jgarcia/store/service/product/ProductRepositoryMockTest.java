package com.jgarcia.store.service.product;


import com.jgarcia.store.service.product.entity.Category;
import com.jgarcia.store.service.product.entity.Product;
import com.jgarcia.store.service.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByCategory(){
        Product product01 = Product.builder()
                .name("computer")
                .description("laptop")
                .status("Created")
                .stock(10.0)
                .price(1240.99)
                .category(Category.builder().id(1L).build())
                .createdDate(new Date())
                .build();
        productRepository.save(product01);

        List<Product> products= productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(products.size()).isEqualTo(3);
    }
}
