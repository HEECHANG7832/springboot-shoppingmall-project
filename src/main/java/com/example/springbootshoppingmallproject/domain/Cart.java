package com.example.springbootshoppingmallproject.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer productCount;

    //@Column
    //private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
