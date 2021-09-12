package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.common.CommonFunction;
import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
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

    //전체 상품 조회
    public Page<Product> getProductList(){
        log.info("getProductList()");

        Pageable pageable = PageRequest.of(0, 8);
        return productRepository.findAll(pageable);
    }

    //LargeCategory 조회
    public Page<Product> getPageProductListByLargeCategory(int page, String largeCategory){
        log.info("getPageProductListByLargeCategory(%d %s)", page, largeCategory);

        int realPage = page - 1;
        Pageable pageable = PageRequest.of(realPage, 8);

        if(largeCategory == null){
            return productRepository.findAll(pageable);
        }
        return productRepository.findByLargeCategory(largeCategory, pageable);
    }

    //상품 이름 조회
    public Page<Product> getProductListByProductName(int page, String productName) {
        log.info("getProductListByProductName(%d %s)", page, productName);

        int realPage = page - 1;
        Pageable pageable = PageRequest.of(realPage, 8);

        if(productName == null){
            return productRepository.findAll(pageable);
        }

        return productRepository.findByProductNameContains(productName, pageable);
    }

    //상품 구매 순서별 조회
    public List<ProductResponseDto.MainProductResponseDto> getProductListSortByPurchaseCountDesc(){
        log.info("getProductListSortByPurchaseCount()");

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
        log.info("getProductListByUserId(%d)", userId);

        List<Product> products = productRepository.findAllByUserId(userId);

        return products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    // 상품 추가
    public Long addProduct(ProductRequestDto productRequestDto) {
        log.info(productRequestDto.toString());
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
                .build()).getId();
    }

    //상품 조회
    public ProductResponseDto getProduct(Long id) {
        log.info("ID : " + id);

        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent()){
            //throw new NotExistProductException("존재하지 않는 상품입니다.");
            return null;
        }

        Product product = productOpt.get();

        return ProductResponseDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description((product.getDescription()))
                .price(product.getPrice())
                .titleImg(product.getTitleImg())
                .largeCategory(product.getLargeCategory())
                .totalCount(product.getTotalCount())
                .build();
    }

    public Page<Product> getRelatedProductList(Long id){
        log.info("product Id : ", id);

        String largeCategory = productRepository.findById(id).get().getLargeCategory();

        Pageable pageable = PageRequest.of(0, 4);

        return productRepository.findByLargeCategory(largeCategory, pageable);
    }

    // 상품 정보 수정
    public String updateProduct(Long id, ProductRequestDto productRequestDto) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent()){
            //throw new NotExistProductException("존재하지 않는 상품입니다.");
            return "존재하지 않는 상품입니다";
        }

        Product product = productOpt.get();

        product.setProductName(productRequestDto.getProductName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setProductStatus(productRequestDto.getProductStatus());
        product.setTitleImg(productRequestDto.getTitleImg());
        product.setTotalCount(productRequestDto.getTotalCount());
        product.setLargeCategory(productRequestDto.getLargeCategory());

        productRepository.save(product);

        return "상품 정보 수정이 완료되었습니다.";
    }

    //상품 삭제
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "상품 삭제 완료";
    }


}
