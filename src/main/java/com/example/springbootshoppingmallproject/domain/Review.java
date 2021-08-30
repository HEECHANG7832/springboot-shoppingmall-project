package com.example.springbootshoppingmallproject.domain;

import com.example.springbootshoppingmallproject.domain.user.User;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private int rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
