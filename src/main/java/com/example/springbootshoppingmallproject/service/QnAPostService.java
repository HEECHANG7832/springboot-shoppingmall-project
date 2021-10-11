package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.domain.*;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import com.example.springbootshoppingmallproject.dto.QnAPostRequestDto;
import com.example.springbootshoppingmallproject.dto.QnAPostResponseDto;
import com.example.springbootshoppingmallproject.dto.ReviewRequestDto;
import com.example.springbootshoppingmallproject.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class QnAPostService {

    private final QnAPostRepository qnAPostRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    //해당 product의 모든 super QnA post 조회
    public List<QnAPostResponseDto> getQnAPostList(Long productId) {

        List<QnAPost> qnAPosts = qnAPostRepository.findAllByProductIdAndSuperQnAPostIsNull(productId);

        return qnAPosts.stream().map(QnAPostResponseDto::new).collect(Collectors.toList());
    }

    //특정 QnA post와 관련된 post 조회
    public QnAPostResponseDto.QnAPostDetailResponseDto getQnAPostDetailList(Long productId, Long postId) {

        QnAPost qnAPost = qnAPostRepository.findById(postId).orElseThrow(()-> new RuntimeException("존재하지 않는 Post입니다."));

        return new QnAPostResponseDto.QnAPostDetailResponseDto(qnAPost);
    }

    //QnA 작성
    public Long addQnAPost(QnAPostRequestDto qnAPostRequestDto) {

        User user = userRepository.getById(qnAPostRequestDto.getUserId());
        Product product = productRepository.getById(qnAPostRequestDto.getProductId());

        QnAPost post = QnAPost.builder()
                .title(qnAPostRequestDto.getTitle())
                .content(qnAPostRequestDto.getContent())
                .user(user)
                .product(product)
                .build();

        return qnAPostRepository.save(post).getId();
    }

    public Long addQnAPostComment(QnAPostRequestDto qnAPostRequestDto) {

        User user = userRepository.getById(qnAPostRequestDto.getUserId());
        Product product = productRepository.getById(qnAPostRequestDto.getProductId());

        QnAPost superQnAPost = qnAPostRepository.findById(qnAPostRequestDto.getQnAPostId())
                .orElseThrow(()-> new RuntimeException("존재하지 않는 Post입니다."));
        List<QnAPost> comments = superQnAPost.getQnAPosts();

        QnAPost comment = QnAPost.builder()
                .content(qnAPostRequestDto.getContent())
                .user(user)
                .product(product)
                .superQnAPost(superQnAPost) //양방향 관계
                .build();

        comments.add(comment);

        return qnAPostRepository.save(comment).getId();
    }


//    public String updateReview(Long reviewId, ReviewRequestDto reviewRequestDto) {
//
//        Review review = reviewRepository.getById(reviewId);
//
//        review.setTitle(reviewRequestDto.getTitle());
//        review.setContent(reviewRequestDto.getContent());
//        review.setRate(reviewRequestDto.getRate());
//
//        reviewRepository.save(review);
//
//        return "review 수정 성공";
//    }
//
//    public String deleteReview(Long reviewId) {
//        reviewRepository.deleteById(reviewId);
//        return "review 삭제 성공";
//    }
}
