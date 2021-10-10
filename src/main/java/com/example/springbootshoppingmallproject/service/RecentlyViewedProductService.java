package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProduct;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProductRepository;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import com.example.springbootshoppingmallproject.dto.ProductResponseDto;
import com.example.springbootshoppingmallproject.dto.RecentlyViewedResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class RecentlyViewedProductService {

    RecentlyViewedProductRepository recentlyViewedProductsRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    //최근 뷰 조회
    public List<RecentlyViewedResponseDto> getRecentlyViewedProduct(Long userId){

        List<RecentlyViewedProduct> rvpList = recentlyViewedProductsRepository.findAllByUserIdOrderByModifiedDateDesc(userId);

        return rvpList.stream().map(RecentlyViewedResponseDto::new).collect(Collectors.toList());
    }

    //최근 뷰 삽입
    public void addRecentlyViewedProduct(Long userId, Long productId){

        User user = userRepository.getById(userId);
        Product product = productRepository.getById(productId);

        recentlyViewedProductsRepository.save(RecentlyViewedProduct.builder()
                .user(user)
                .product(product)
                .build());
    }

}
