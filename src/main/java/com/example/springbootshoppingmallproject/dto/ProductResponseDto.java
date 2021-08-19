package com.example.springbootshoppingmallproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long id;
    private String productName;
    private String description;
    private Integer price;
    private Integer purchaseCount;
    private Integer limitCount;
    private Integer totalCount;
    private Integer productStatus;
    private String titleImg;
    private String largeCategory;
}
