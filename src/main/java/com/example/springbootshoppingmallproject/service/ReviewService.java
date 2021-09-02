package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.domain.Review;
import com.example.springbootshoppingmallproject.domain.ReviewRepository;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import com.example.springbootshoppingmallproject.dto.ProductResponseDto;
import com.example.springbootshoppingmallproject.dto.ReviewRequestDto;
import com.example.springbootshoppingmallproject.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<ReviewResponseDto> getReviewList(Long productId) {

        List<Review> reviews = reviewRepository.findAllByProductId(productId);

        return reviews.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }

    public Long addReview(ReviewRequestDto reviewRequestDto) {

        User user = userRepository.getById(reviewRequestDto.getUserId());
        Product product = productRepository.getById(reviewRequestDto.getProductId());

        Review review = Review.builder()
                .title(reviewRequestDto.getTitle())
                .content(reviewRequestDto.getContent())
                .rate(reviewRequestDto.getRate())
                .user(user)
                .product(product)
                .build();

        return reviewRepository.save(review).getId();
    }

    public String updateReview(Long reviewId, ReviewRequestDto reviewRequestDto) {

        Review review = reviewRepository.getById(reviewId);

        review.setTitle(reviewRequestDto.getTitle());
        review.setContent(reviewRequestDto.getContent());
        review.setRate(reviewRequestDto.getRate());

        reviewRepository.save(review);

        return "review 수정 성공";
    }

    public String deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        return "review 삭제 성공";
    }
}
