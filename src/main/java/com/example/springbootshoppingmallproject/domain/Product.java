package com.example.springbootshoppingmallproject.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private Integer price;

    @Column
    private Integer purchaseCount;

    @Column
    private Integer limitCount;

    @Column
    private Integer totalCount;

    @Column
    private Integer productStatus;

    @Column
    private String titleImg;

    @Column
    private String largeCategory;

}
