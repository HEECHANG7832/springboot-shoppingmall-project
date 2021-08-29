package com.example.springbootshoppingmallproject.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByLargeCategory(String largeCategory, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    List<Product> findTop8ByOrderByPurchaseCountDesc();
}
