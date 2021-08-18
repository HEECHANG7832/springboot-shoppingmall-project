package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getProductList("123"));
        return "index";
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
