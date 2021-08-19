package com.example.springbootshoppingmallproject.service;


import com.example.springbootshoppingmallproject.domain.Cart;
import com.example.springbootshoppingmallproject.domain.CartRepository;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
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

    //
    public List<CartResponseDto> getCartList(){
        return cartRepository.findAll().stream().map(CartResponseDto::new).collect(Collectors.toList());
    }

    //
    public void addCart(CartRequestDto cartRequestDto) {

        //
        Optional<Product> productOpt = productRepository.findById(cartRequestDto.getProductId());

//        if (!productOpt.isPresent())
//            throw new NotExistProductException("존재하지 않는 상품입니다.");

        Product product = productOpt.get();

//        if (product.getLimitCount() < cartRequestDto.getProductCount())
//            throw new ProductLimitCountException("재고가 없습니다.");

        cartRepository.save(Cart.builder()
                            .product(product)
                            .productCount(cartRequestDto.getProductCount())
                            .build());
    }
}
