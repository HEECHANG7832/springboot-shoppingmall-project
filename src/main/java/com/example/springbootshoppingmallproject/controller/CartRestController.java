package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.dto.CartRequestDto;
import com.example.springbootshoppingmallproject.service.CartService;
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
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CartRestController {

    private final CartService cartService;

    // 카트 조회
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    @GetMapping("/users/{userId}/carts")
//    public ResponseEntity<?> getCartList(@PathVariable("userId") Long userId) {
//        return ResponseEntity.ok().body(cartService.getCartList(userId));
//    }

    // 카트 추가
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/carts")
    public ResponseEntity<?> addCart(@RequestBody CartRequestDto cartRequestDto) {
        cartService.addCart(cartRequestDto);
        return ResponseEntity.ok().body("장바구니에 추가되었습니다.");
    }

    // 카트 삭제
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @DeleteMapping("/carts/{id}")
    public ResponseEntity<?> removeCart(@PathVariable Long id) {

        //cartService.removeCart(id);

        return ResponseEntity.ok().body("삭제 되었습니다.");
    }
}
