package com.example.springbootshoppingmallproject.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByCategoryTest() { // create, read, update, delete

        productRepository.save(new Product(2L, "ball2", 1, 1, 1, 1, 1, "url", "sports"));

        List<Product> products = productRepository.findByCategory("sports");

        assertThat(products.get(0).getCategory()).isEqualTo("sports");

    }
}