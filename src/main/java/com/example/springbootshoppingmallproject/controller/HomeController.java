package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.RecentlyViewedProducts;
import com.example.springbootshoppingmallproject.dto.ProductRequestDto;
import com.example.springbootshoppingmallproject.service.CartService;
import com.example.springbootshoppingmallproject.service.ProductService;
import com.example.springbootshoppingmallproject.service.RecentlyViewedProductsService;
import com.example.springbootshoppingmallproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    private final ReviewService reviewService;
    private final RecentlyViewedProductsService recentlyViewedProductsService;

    //메인 화면 상품 리스트
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        log.info("/");

        model.addAttribute("products", productService.getProductList());
        model.addAttribute("rankproducts", productService.getProductListSortByPurchaseCountDesc());

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "index";
    }

    //개별 상품 상세보기
    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable Long id, @LoginUser SessionUser user){
        log.info("/product/{id}");

        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("relatedproducts", productService.getRelatedProductList(id));
        model.addAttribute("reviews", reviewService.getReviewList(id));

        if (user != null) {
            model.addAttribute("user", user);
            recentlyViewedProductsService.addRecentlyViewedProduct(user.getId(), id);
        }

        return "product";
    }

    //전체 상품 상세보기
    @GetMapping("/productlist/{page}")
    public String ProductList(Model model, @PathVariable int page, @RequestParam(required = false, name = "search") String productName, @LoginUser SessionUser user){

        log.info("/productlist");

        Page<Product> productPages = productService.getProductListByProductName(page, productName);

        model.addAttribute("products", productPages);
        model.addAttribute("pageCount", productPages.getTotalPages());
        model.addAttribute("currentPage", productPages.getNumber());

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "productlist";
    }

    //상품 조회 화면
    @GetMapping("/products/admin")
    public String ProductAdmin(Model model, @LoginUser SessionUser user){
        log.info("/products/admin");

        model.addAttribute("products", productService.getProductListByUserId(user.getId()));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-admin";
    }

    //상품 등록 화면
    @GetMapping("/product/save")
    public String ProductSave(Model model, @LoginUser SessionUser user){
        log.info("/product/save");

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-save";
    }

    //상품 수정 화면
    @GetMapping("/product/update/{productid}")
    public String ProductUpdate(Model model, @PathVariable(name="productid")Long productId, @LoginUser SessionUser user){
        log.info("/product/update");

        model.addAttribute("product", productService.getProduct(productId));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-save";
    }

    //
    // 카트 조회
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    //@GetMapping("/users/{userId}/carts/{page}")
    @GetMapping("/carts")
    public String getCartList(Model model, @LoginUser SessionUser user) {
        log.info("HomeController  /carts");

        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("cartlist", cartService.getCartList(user.getId()));
        }

        return "carts";
    }

    @GetMapping("/loginform")
    public String login(){
        return "loginform";
    }
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
