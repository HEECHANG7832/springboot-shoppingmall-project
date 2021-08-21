package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.service.CartService;
import com.example.springbootshoppingmallproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;
    private final CartService cartService;

    //메인 화면 상품 리스트
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        log.info("link /");

        model.addAttribute("products", productService.getProductList(null));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "index";
    }

    //개별 상품 상세보기
    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable Long id, @LoginUser SessionUser user){
        log.info("link /product/{id}");
        model.addAttribute("product", productService.getProduct(id));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product";
    }

    //
    // 카트 조회
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    //@GetMapping("/users/{userId}/carts/{page}")
    @GetMapping("/carts")
    public String getCartList(Model model, @LoginUser SessionUser user) {
        log.info("link /carts");
        model.addAttribute("cartlist", cartService.getCartList(user.getId()));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "carts";
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
