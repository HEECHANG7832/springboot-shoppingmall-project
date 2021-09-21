package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.dto.ReviewRequestDto;
import com.example.springbootshoppingmallproject.dto.ReviewResponseDto;
import com.example.springbootshoppingmallproject.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "Reviews", description = "리뷰 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ReviewRestController {

    private final ReviewService reviewService;

    //리뷰 가져오기
//    @GetMapping("/products/{productid}/reviews")
//    public ResponseEntity<?> getReviewList(@PathVariable("productid") Long productId){
//        return ResponseEntity.ok().body(reviewService.getReviewList(productId));
//    }

    @ApiOperation(value = "리뷰 작성")
    @PostMapping("/products/{productid}/reviews")
    public Long addReview( @LoginUser SessionUser user,
                                        @PathVariable("productid") Long productId,
                                        @RequestBody ReviewRequestDto reviewRequestDto){
        reviewRequestDto.setProductId(productId);
        reviewRequestDto.setUserId(user.getId());
        return reviewService.addReview(reviewRequestDto);
    }

    //리뷰 수정하기
//    @PutMapping("/products/{productid}/reviews/{reviewid}")
//    public ResponseEntity<?> updateReview(@LoginUser SessionUser user,
//                                          @PathVariable("productid") Long productId,
//                                          @PathVariable("reviewid") Long reviewId,
//                                          @RequestBody ReviewRequestDto reviewRequestDto){
//        reviewRequestDto.setProductId(productId);
//        reviewRequestDto.setUserId(user.getId());
//        return ResponseEntity.ok().body(reviewService.updateReview(reviewId, reviewRequestDto));
//    }

    //리뷰 삭제하기
//    @DeleteMapping("/reviews/{reviewid}")
//    public ResponseEntity<?> updateReview(@LoginUser SessionUser user,
//                                          @PathVariable("reviewid") Long reviewId){
//        return ResponseEntity.ok().body(reviewService.deleteReview(reviewId));
//    }
}
