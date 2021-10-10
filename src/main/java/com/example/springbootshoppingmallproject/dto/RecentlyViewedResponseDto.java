package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Cart;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProduct;
import com.example.springbootshoppingmallproject.domain.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RecentlyViewedResponseDto {

    private Long Id;
    private Product product;
    private LocalDateTime modifyedDate;

    public RecentlyViewedResponseDto(RecentlyViewedProduct entity){
        this.Id = entity.getId();
        this.product = entity.getProduct();
        this.modifyedDate = entity.getModifiedDate();

    }
}
