package com.example.springbootshoppingmallproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnAPostRequestDto {

    private String title;
    private String content;
    private Long userId;
    private Long productId;
    private Long qnAPostId;
}
