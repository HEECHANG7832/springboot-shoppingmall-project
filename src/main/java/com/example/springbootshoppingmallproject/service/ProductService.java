package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.domain.Product;
import com.example.springbootshoppingmallproject.domain.ProductRepository;
import com.example.springbootshoppingmallproject.dto.ProductRequestDto;
import com.example.springbootshoppingmallproject.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    //전체 상품 조회
    public List<Product> getProductList(String largeCategory){
        log.info("largeCategory : ", largeCategory);

        if(largeCategory == null){
            return productRepository.findAll();
        }
        return productRepository.findByLargeCategory(largeCategory);
    }

    // 상품 추가
    public String addProduct(ProductRequestDto productRequestDto) {
        productRepository.save(Product.builder()
                .productName(productRequestDto.getProductName())
                .description((productRequestDto.getDescription()))
                .price(productRequestDto.getPrice())
                .purchaseCount(0)
                .limitCount(productRequestDto.getTotalCount())
                .totalCount(productRequestDto.getTotalCount())
                .productStatus((productRequestDto.getProductStatus()))
                .titleImg(productRequestDto.getTitleImg())
                .largeCategory(productRequestDto.getLargeCategory())
                .build());

        return "상품이 추가되었습니다.";
    }

    //상품 조회
    public ProductResponseDto getProduct(Long id) {
        log.info("ID : ", id);

        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent()){
            //throw new NotExistProductException("존재하지 않는 상품입니다.");
            return null;
        }

        Product product = productOpt.get();

        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .description((product.getDescription()))
                .price(product.getPrice())
                .titleImg(product.getTitleImg())
                .largeCategory(product.getLargeCategory())
                .totalCount(product.getTotalCount())
                .build();
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
