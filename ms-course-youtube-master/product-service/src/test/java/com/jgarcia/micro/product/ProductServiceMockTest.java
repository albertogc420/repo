package com.jgarcia.micro.product;

import com.jgarcia.micro.product.entity.Category;
import com.jgarcia.micro.product.entity.Product;
import com.jgarcia.micro.product.repository.ProductRepository;
import com.jgarcia.micro.product.service.ProductService;
import com.jgarcia.micro.product.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService =  new ProductServiceImpl( productRepository);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

    @Test
   public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
       Assertions.assertThat(found.getName()).isEqualTo("computer");
   }

   @Test
   public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
   }

    @Test
    public void solution() {

       int[] array = {-7,-5,-3,-1,0,3,6,7};
       //int[] array = {-5,3,-1,0,3,6};
        Set<Integer> set = Arrays.stream(array).map(item -> Math.abs(item)).boxed().collect(Collectors.toSet());
        //Set<Integer> set = IntStream.of(array).boxed().collect(Collectors.toSet());
        // write your code in Java SE 8
        int total = Long.valueOf (set.stream().count()).intValue();

        assertTrue(total == 9, "real value: "+total);
    }

    @Test
    public void solution2() {
        //int[] array = {-7,-5,-3,-1,0,3,6,7};

    }

    public int solution(int[] array) {
        // write your code in Java SE 8
        int max = 1;

        for (int i = 1; i <= array.length; i++) {
            int finalI = i;
            if (!IntStream.of(array).anyMatch(value -> value == finalI)) {
                return i;
            }
            if (i > max) max = i;
        }
        return max + 1;
    }
}
