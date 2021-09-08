package com.example.springbootshoppingmallproject.config.auth.dto;

import com.example.springbootshoppingmallproject.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUser implements Serializable {

    //인증된 사용자의 정보만 필요
    //User클래스를 바로 사용할 수 없는 이유는 Entity인 User클래스를 직렬화 할 수 없기 때문
    //Entity는 다른 Entity와 관계가 생길 수 있기 때문에 성능 이슈상 직렬화 불가
    private Long id;
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
