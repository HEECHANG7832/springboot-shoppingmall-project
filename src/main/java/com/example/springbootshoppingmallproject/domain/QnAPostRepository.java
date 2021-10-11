package com.example.springbootshoppingmallproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QnAPostRepository extends JpaRepository<QnAPost, Long> {
    List<QnAPost> findAllByProductId(Long productId);
}
