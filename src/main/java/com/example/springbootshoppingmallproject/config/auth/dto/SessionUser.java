package com.example.springbootshoppingmallproject.config.auth.dto;

import com.example.springbootshoppingmallproject.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long Id;
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.Id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
