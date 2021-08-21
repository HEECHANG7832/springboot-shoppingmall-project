package com.example.springbootshoppingmallproject.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    SELLER("ROLE_SELLER", "판매자");

    private final String key;
    private final String title;

}