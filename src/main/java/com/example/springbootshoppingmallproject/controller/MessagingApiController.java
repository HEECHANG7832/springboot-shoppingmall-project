package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.dto.CartResponseDto;
import com.example.springbootshoppingmallproject.service.CartService;
import com.example.springbootshoppingmallproject.service.LineMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "messaging", description = "메세징 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MessagingApiController {

    private final LineMessageService lineMessageService;

    @ApiOperation(value = "메세징 테스트")
    @GetMapping("/messaging/test")
    public void test() {
        lineMessageService.exchange();
    }
}
