package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.dto.QnAPostRequestDto;
import com.example.springbootshoppingmallproject.dto.ReviewRequestDto;
import com.example.springbootshoppingmallproject.service.QnAPostService;
import com.example.springbootshoppingmallproject.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "Reviews", description = "리뷰 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class QnAPostRestController {

    private final QnAPostService qnAPostService;

    @ApiOperation(value = "QnA 포스트 작성")
    @PostMapping("/products/{productid}/qnaPost")
    public Long addQnAPost( @LoginUser SessionUser user,
                                        @PathVariable("productid") Long productId,
                                        @RequestBody QnAPostRequestDto qnAPostRequestDto){
        qnAPostRequestDto.setProductId(productId);
        qnAPostRequestDto.setUserId(user.getId());
        return qnAPostService.addQnAPost(qnAPostRequestDto);
    }

    //comment
    @PostMapping("/products/{productid}/qnaPost/{qnapostid}")
    public Long addQnAPostComment(@LoginUser SessionUser user,
                                          @PathVariable("productid") Long productId,
                                          @PathVariable("qnapostid") Long qnaPostId,
                                          @RequestBody QnAPostRequestDto qnAPostRequestDto){
        qnAPostRequestDto.setProductId(productId);
        qnAPostRequestDto.setUserId(user.getId());
        qnAPostRequestDto.setQnAPostId(qnaPostId);
        return qnAPostService.addQnAPostComment(qnAPostRequestDto);
    }

}
