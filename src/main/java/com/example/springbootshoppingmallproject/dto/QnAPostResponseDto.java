package com.example.springbootshoppingmallproject.dto;

import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.QnAPost;
import com.example.springbootshoppingmallproject.domain.Review;
import com.example.springbootshoppingmallproject.domain.user.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class QnAPostResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private User user;
    private Long productId;
    private List<QnAPost> qnAPosts;

    public QnAPostResponseDto(QnAPost entity){
        this.id = entity.getId();
        this.user = entity.getUser();
        this.productId = entity.getProduct().getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class QnAPostDetailResponseDto implements Serializable {
        private Long id;
        private String title;
        private String content;
        private LocalDateTime createdDate;
        private User user;
        private Long productId;
        private List<QnAPost> qnaPosts;

        public QnAPostDetailResponseDto(QnAPost entity){
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.content = entity.getContent();
            this.createdDate = entity.getCreatedDate();
            this.user = entity.getUser();
            this.productId = entity.getProduct().getId();
            this.qnaPosts = entity.getQnAPosts();
        }
    }
}
