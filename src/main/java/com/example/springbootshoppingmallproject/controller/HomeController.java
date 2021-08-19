package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;

    //메인 화면 상품 리스트
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getProductList(null));
        return "index";
    }

    //개별 상품 상세보기
    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

//    @GetMapping("/login")
//    public String login(){
//        return "loginForm";
//    }
//
//    @GetMapping("/login-error")
//    public String loginError(Model model){
//        model.addAttribute("loginError", true);
//        return "loginForm";
//    }
//
//    @ResponseBody
//    @GetMapping("/auth")
//    public Authentication auth(){
//        return SecurityContextHolder.getContext().getAuthentication();
//    }
//
//
//    @GetMapping("/access-denied")
//    public String accessDenied(){
//        return "accessDenied";
//    }
}
