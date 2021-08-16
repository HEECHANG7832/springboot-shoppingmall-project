package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.dto.ProductRequestDto;
import com.example.springbootshoppingmallproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product/api")
public class ProductRestController {

    private final ProductService productService;

    //상품 전체 조회
    @GetMapping("/products")
    public ResponseEntity<?> getProductList(@RequestParam(value = "category", required = false) String Category){
        return ResponseEntity.ok().body(productService.getProductList(Category));
    }

    //상품 등록
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok().body(productService.addProduct(productRequestDto));
    }

    //상품 상세 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    //상품 수정
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDto productRequestDto) {
        return ResponseEntity.ok().body(productService.updateProduct(id, productRequestDto));
    }

    //상품 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.deleteProduct(id));
    }
}
