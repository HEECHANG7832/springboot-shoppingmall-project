package com.example.springbootshoppingmallproject.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer price;

    @Column
    private Integer purchaseCount;

    @Column
    private Integer rateAvg;

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

    @Column
    private Integer shippingCost;

    @Column
    private Integer shippingDueDate;

    @Column
    private Integer saleRate;

}
