package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.common.CommonFunction;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.domain.user.User;
import com.example.springbootshoppingmallproject.domain.user.UserRepository;
import com.example.springbootshoppingmallproject.dto.ProductRequestDto;
import com.example.springbootshoppingmallproject.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    //전체 상품 조회
    public Page<Product> getProductList(){
        Pageable pageable = PageRequest.of(0, 8);
        return productRepository.findAll(pageable);
    }

    //LargeCategory 조회
    public Page<Product> getPageProductListByLargeCategory(int page, String largeCategory){

        int realPage = page - 1;
        Pageable pageable = PageRequest.of(realPage, 8);

        if(largeCategory == null){
            return productRepository.findAll(pageable);
        }
        return productRepository.findByLargeCategory(largeCategory, pageable);
    }

    //상품 이름 조회
    public Page<Product> getProductListByProductName(int page, String productName) {

        int realPage = page - 1;
        Pageable pageable = PageRequest.of(realPage, 8);

        if(productName == null){
            return productRepository.findAll(pageable);
        }

        return productRepository.findByProductNameContains(productName, pageable);
    }

    //상품 구매 순서별 조회
    public List<ProductResponseDto.MainProductResponseDto> getProductListSortByPurchaseCountDesc(){

        List<Product> products = productRepository.findTop8ByOrderByPurchaseCountDesc();

        List<ProductResponseDto.MainProductResponseDto> mainProductResponseDtoList = new ArrayList<>();

        Integer index = 1;
        for(Product product : products)
        {
            mainProductResponseDtoList.add(new ProductResponseDto.MainProductResponseDto(product, index++));
        }

        return mainProductResponseDtoList;
    }

    //User에 해당하는 상품 조회
    public List<ProductResponseDto> getProductListByUserId(Long userId) {

        List<Product> products = productRepository.findAllByUserId(userId);

        return products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    // 상품 추가
    public Long addProduct(ProductRequestDto productRequestDto, Long userId) {
        log.info(productRequestDto.toString());

        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("존재하지 않는 유저입니다."));

        return productRepository.save(Product.builder()
                .productName(productRequestDto.getProductName())
                .description((productRequestDto.getDescription()))
                .price(productRequestDto.getPrice())
                .purchaseCount(0)
                .rateAvg(0)
                .limitCount(productRequestDto.getTotalCount())
                .totalCount(productRequestDto.getTotalCount())
                .productStatus((productRequestDto.getProductStatus()))
                .titleImg(productRequestDto.getTitleImg())
                .largeCategory(productRequestDto.getLargeCategory())
                .shippingCost(productRequestDto.getShippingCost())
                .shippingDueDate(productRequestDto.getShippingDueDate())
                .saleRate(productRequestDto.getSaleRate())
                .user(user)
                .build()).getId();
    }

    //상품 조회
    public ProductResponseDto getProduct(Long id) {

        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent()){
            //throw new NotExistProductException("존재하지 않는 상품입니다.");
            return null;
        }

        Product product = productOpt.get();

        return new ProductResponseDto(product);
    }

    public Page<Product> getRelatedProductList(Long id){

        String largeCategory = productRepository.findById(id).get().getLargeCategory();

        Pageable pageable = PageRequest.of(0, 4);

        return productRepository.findByLargeCategory(largeCategory, pageable);
    }

    // 상품 정보 수정
    public Long updateProduct(Long id, ProductRequestDto productRequestDto) {
        Optional<Product> productOpt = productRepository.findById(id);

//        if (!productOpt.isPresent()){
//            throw new NotExistProductException("존재하지 않는 상품입니다.");
//        }

        Product product = productOpt.get();

        product.setProductName(productRequestDto.getProductName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setTotalCount(productRequestDto.getTotalCount());
        product.setProductStatus(productRequestDto.getProductStatus());
        product.setTitleImg(productRequestDto.getTitleImg());
        product.setLargeCategory(productRequestDto.getLargeCategory());
        product.setShippingCost(productRequestDto.getShippingCost());
        product.setSaleRate(productRequestDto.getSaleRate());

        return productRepository.save(product).getId();
    }

    //상품 삭제
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "상품 삭제 완료";
    }


}
