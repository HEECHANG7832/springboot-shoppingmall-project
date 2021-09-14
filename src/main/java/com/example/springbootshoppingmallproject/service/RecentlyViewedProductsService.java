package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProducts;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProductsRepository;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RecentlyViewedProductsService {

    RecentlyViewedProductsRepository recentlyViewedProductsRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    //전체 상품 조회
    public void addRecentlyViewedProduct(Long userId, Long productId){
        log.info("addRecentlyViewedProduct()");

        User user = userRepository.getById(userId);
        Product product = productRepository.getById(productId);

        recentlyViewedProductsRepository.save(RecentlyViewedProducts.builder()
                .user(user)
                .product(product)
                .build());
    }
}
