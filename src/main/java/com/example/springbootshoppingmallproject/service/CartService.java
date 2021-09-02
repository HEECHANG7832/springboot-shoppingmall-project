package com.example.springbootshoppingmallproject.service;


import com.example.springbootshoppingmallproject.domain.Cart;
import com.example.springbootshoppingmallproject.domain.CartRepository;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import com.example.springbootshoppingmallproject.dto.CartRequestDto;
import com.example.springbootshoppingmallproject.dto.CartResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class CartService {

    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;

    public List<CartResponseDto> getCartList(Long userId){
        return cartRepository.findAllByUserId(userId).stream().map(CartResponseDto::new).collect(Collectors.toList());
    }

    public Long addCart(CartRequestDto cartRequestDto) {

        User user = userRepository.findById(cartRequestDto.getUserId()).orElseThrow(()-> new RuntimeException("존재하지 않는 유저입니다."));

        Optional<Product> productOpt = productRepository.findById(cartRequestDto.getProductId());

//        if (!productOpt.isPresent())
//            throw new NotExistProductException("존재하지 않는 상품입니다.");

        Product product = productOpt.get();

//        if (product.getLimitCount() < cartRequestDto.getProductCount())
//            throw new ProductLimitCountException("재고가 없습니다.");

        return cartRepository.save(Cart.builder()
                            .user(user)
                            .product(product)
                            .productCount(cartRequestDto.getProductCount())
                            .build()).getId();
    }
}
