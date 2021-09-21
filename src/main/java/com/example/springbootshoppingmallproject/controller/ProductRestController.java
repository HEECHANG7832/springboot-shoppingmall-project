package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.dto.ProductRequestDto;
import com.example.springbootshoppingmallproject.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(value = "Products", description = "상품 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    private final ProductService productService;

//    //상품 전체 조회
//    @GetMapping("/products")
//    public ResponseEntity<?> getProductList(@RequestParam(value = "category", required = false) String Category){
//        return ResponseEntity.ok().body(productService.getProductList());
//    }

    @ApiOperation(value = "상품 이름 조회")
    @GetMapping("/products/{productname}")
    public Page<Product> getProductListByProductName(@PathVariable(value = "productname") String productName){
        return productService.getProductListByProductName(1, productName);
    }

    @ApiOperation(value = "상품 등록")
    @PostMapping("/products")
    public Long addProduct(@RequestBody ProductRequestDto productRequestDto, @LoginUser SessionUser user) {
        return productService.addProduct(productRequestDto, user.getId());
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "상품 수정")
    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @ApiOperation(value = "상품 삭제")
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "{ \"message\" : 삭제 성공}";
    }
}
