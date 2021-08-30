package com.example.springbootshoppingmallproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@ToString
public class ReviewRequestDto {

    private Long userId;
    private Long productId;
    private String title;
    private int rate;
    private String content;
}
