package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartRequestDto {
    private Long productId;
    private Integer productCount;
}
