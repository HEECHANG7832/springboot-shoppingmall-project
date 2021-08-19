package com.example.springbootshoppingmallproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
public class ProductRequestDto {

    //@NotBlank(message = "상품명을 작성해 주세요")
    //@Size(max = 200, message = "상품명 길이 200")
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
