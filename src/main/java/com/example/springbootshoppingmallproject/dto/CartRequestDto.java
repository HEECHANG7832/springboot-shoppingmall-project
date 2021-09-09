package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class CartRequestDto {
    private Long cartId;
    private Long userId;
    private Long productId;
    private Integer productCount;
}
