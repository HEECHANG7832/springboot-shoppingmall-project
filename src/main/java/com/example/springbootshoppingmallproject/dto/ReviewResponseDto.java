package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewResponseDto {

    private Long userId;
    private Long productId;
    private String title;
    private int rate;
    private String content;

    public ReviewResponseDto(Review entity){
        this.userId = entity.getUser().getId();
        this.productId = entity.getProduct().getId();
        this.title = entity.getTitle();
        this.rate = entity.getRate();
        this.content = entity.getContent();
    }
}
