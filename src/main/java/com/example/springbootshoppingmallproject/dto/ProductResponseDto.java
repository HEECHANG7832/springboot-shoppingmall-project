package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Product;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

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

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MainProductResponseDto implements Serializable {
        private Integer index;
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

        public MainProductResponseDto(Product entity, Integer index){
            this.index = index;
            this.id = entity.getId();
            this.productName = entity.getProductName();
            this.description = entity.getDescription();
            this.price = entity.getPrice();
            this.purchaseCount = entity.getPurchaseCount();
            this.limitCount = entity.getLimitCount();
            this.totalCount = entity.getTotalCount();
            this.productStatus = entity.getProductStatus();
            this.titleImg = entity.getTitleImg();
            this.largeCategory = entity.getLargeCategory();
        }
    }
}
