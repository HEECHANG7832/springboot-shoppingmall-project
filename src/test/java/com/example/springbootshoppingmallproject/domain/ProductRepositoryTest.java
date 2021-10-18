package com.example.springbootshoppingmallproject.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

//    Page<Product> findByLargeCategory(String largeCategory, Pageable pageable);
//    Page<Product> findAll(Pageable pageable);
//    List<Product> findTop8ByOrderByPurchaseCountDesc();
//    Page<Product> findByProductNameContains(String productName, Pageable pageable);
//    List<Product> findAllByUserId(Long userId);
// given, when, then

    @DisplayName("대분류 검색 쿼리 테스트")
    @Test
    public void findByLargeCategoryTest() {

        //given
        String largeCategory = "Mark Rothko";

        //when
        int realPage = 0;
        Pageable pageable = PageRequest.of(realPage, 8);
        Page<Product> products = productRepository.findByLargeCategory(largeCategory, pageable);

        //then
        assertThat(products.getContent().get(0).getLargeCategory()).isEqualTo(largeCategory);
    }

    @DisplayName("구매 순 Top 8 쿼리 테스트")
    @Test
    public void findTop8ByOrderByPurchaseCountDescTest() {

        //given

        //when
        List<Product> products = productRepository.findTop8ByOrderByPurchaseCountDesc();

        //then
        assertThat(products.get(0).getPurchaseCount()).isGreaterThan(products.get(1).getPurchaseCount());
        assertThat(products.get(1).getPurchaseCount()).isGreaterThan(products.get(2).getPurchaseCount());
        assertThat(products.get(2).getPurchaseCount()).isGreaterThan(products.get(3).getPurchaseCount());
        assertThat(products.get(3).getPurchaseCount()).isGreaterThan(products.get(4).getPurchaseCount());
    }
}