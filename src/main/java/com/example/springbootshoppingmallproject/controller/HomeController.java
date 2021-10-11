package com.example.springbootshoppingmallproject.controller;

import com.example.springbootshoppingmallproject.config.auth.LoginUser;
import com.example.springbootshoppingmallproject.config.auth.dto.SessionUser;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "HomeController", description = "뷰 반환 컨트롤러")
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;
    private final CartService cartService;
    private final ReviewService reviewService;
    private final QnAPostService qnAPostService;
    private final RecentlyViewedProductService recentlyViewedProductService;

    @ApiOperation(value = "메인 화면 상품 리스트, 상위 판매 상품 뷰")
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        model.addAttribute("products", productService.getProductList());
        model.addAttribute("rankproducts", productService.getProductListSortByPurchaseCountDesc());

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "index";
    }

    @ApiOperation(value = "개별 상품 상세 뷰")
    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable Long id, @LoginUser SessionUser user){

        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("relatedproducts", productService.getRelatedProductList(id));
        model.addAttribute("reviews", reviewService.getReviewList(id));
        model.addAttribute("qnaPosts", qnAPostService.getQnAPostList(id));

        if (user != null) {
            model.addAttribute("user", user);
            recentlyViewedProductService.addRecentlyViewedProduct(user.getId(), id);
        }

        return "product";
    }

    @ApiOperation(value = "전체 상품 뷰")
    @GetMapping("/productlist/{page}")
    public String ProductList(Model model, @PathVariable int page, @RequestParam(required = false, name = "search") String productName, @LoginUser SessionUser user){

        Page<Product> productPages = productService.getProductListByProductName(page, productName);

        model.addAttribute("products", productPages);
        model.addAttribute("pageCount", productPages.getTotalPages());
        model.addAttribute("currentPage", productPages.getNumber());

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "productlist";
    }
    
    @ApiOperation(value = "판매자 상품 리스트 뷰")
    @GetMapping("/products/admin")
    public String ProductAdmin(Model model, @LoginUser SessionUser user){

        model.addAttribute("products", productService.getProductListByUserId(user.getId()));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-admin";
    }

    @ApiOperation(value = "유저 정보 뷰")
    @GetMapping("/products/user")
    public String ProductUser(Model model, @LoginUser SessionUser user){

        //최근 뷰
        model.addAttribute("recentlyViewedProducts", recentlyViewedProductService.getRecentlyViewedProduct(user.getId()));
        //오더뷰


        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-user";
    }
    
    @ApiOperation(value = "상품 등록 뷰")
    @GetMapping("/product/save")
    public String ProductSave(Model model, @LoginUser SessionUser user){

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-save";
    }

    @ApiOperation(value = "상품 수정 뷰")
    @GetMapping("/product/update/{productid}")
    public String ProductUpdate(Model model, @PathVariable(name="productid")Long productId, @LoginUser SessionUser user){

        model.addAttribute("product", productService.getProduct(productId));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "product-save";
    }
    
    //@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @ApiOperation(value = "카트 조회 뷰")
    @GetMapping("/carts")
    public String getCartList(Model model, @LoginUser SessionUser user) {
        log.info("HomeController  /carts");

        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("cartlist", cartService.getCartList(user.getId()));
        }

        return "carts";
    }

    @ApiOperation(value = "QnA 포스트 뷰")
    @GetMapping("/product/{productid}/qnaPost/{id}")
    public String qnaPostDetail(Model model, @PathVariable(name="productid") Long productId, @PathVariable Long id, @LoginUser SessionUser user){

        model.addAttribute("qnaPostDetailListResponse", qnAPostService.getQnAPostDetailList(productId, id));

        if (user != null) {
            model.addAttribute("user", user);
        }

        return "qnaPost";
    }

    @ApiOperation(value = "로그인 뷰")
    @GetMapping("/loginform")
    public String login(){
        return "loginform";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "accessDenied";
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
