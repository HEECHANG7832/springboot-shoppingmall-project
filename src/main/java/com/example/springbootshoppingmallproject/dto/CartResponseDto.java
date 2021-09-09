package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Cart;
import com.example.springbootshoppingmallproject.domain.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
public class CartResponseDto {

    private Long cartId;
    private Product product;
    private Integer productCount;

    public CartResponseDto(Cart entity){
        this.cartId = entity.getId();
        this.product = entity.getProduct();
        this.productCount = entity.getProductCount();
    }
}
