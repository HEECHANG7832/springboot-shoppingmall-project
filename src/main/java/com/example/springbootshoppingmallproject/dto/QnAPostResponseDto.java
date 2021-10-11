package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.QnAPost;
import com.example.springbootshoppingmallproject.domain.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class QnAPostResponseDto {

    private Long Id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private Long userId;
    private Long productId;
    private Long qnaPostId;

    public QnAPostResponseDto(QnAPost entity){
        this.Id = entity.getId();
        this.userId = entity.getUser().getId();
        this.productId = entity.getProduct().getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
