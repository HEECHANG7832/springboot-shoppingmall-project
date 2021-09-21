package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.dto.CartRequestDto;
import com.example.springbootshoppingmallproject.dto.CartResponseDto;
import com.example.springbootshoppingmallproject.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@Api(tags = "carts", description = "장바구니 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CartRestController {

    private final CartService cartService;
    
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @ApiOperation(value = "장바구니 조회")
    @GetMapping("/users/{userid}/carts")
    public List<CartResponseDto> getCartList(@PathVariable("userid") Long userId) {
        return cartService.getCartList(userId);
    }

    // 카트 추가
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @ApiOperation(value = "장바구니 추가")
    @PostMapping("/carts")
    public Long addCart(@RequestBody CartRequestDto cartRequestDto) {
        return cartService.addCart(cartRequestDto);
    }

    // 카트 변경
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @ApiOperation(value = "장바구니 변경")
    @PutMapping("/carts")
    public Long updateCart(@RequestBody CartRequestDto cartRequestDto) {
        return cartService.updateCart(cartRequestDto);
    }

    // 카트 삭제
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @ApiOperation(value = "장바구니 삭제")
    @DeleteMapping("/carts/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return "{ \"message\" : 삭제 성공}";
    }
}
