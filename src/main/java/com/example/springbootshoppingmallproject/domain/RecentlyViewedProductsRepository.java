package com.example.springbootshoppingmallproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyViewedProductsRepository  extends JpaRepository<RecentlyViewedProducts, Long> {
}
