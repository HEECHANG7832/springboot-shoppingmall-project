package com.example.springbootshoppingmallproject.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LineKey {
    @Value("${lineKey}")
    private String key;
}
