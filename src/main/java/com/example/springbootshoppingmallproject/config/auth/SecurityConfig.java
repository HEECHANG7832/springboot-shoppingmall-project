package com.example.springbootshoppingmallproject.config.auth;

import com.example.springbootshoppingmallproject.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 사용을 위해
                .and()
                    .authorizeRequests() //antMatchers 사용을 위함
                    //권한 관리 대상을 지정
                    .antMatchers("/", "/product", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/assets").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //설정 외 요청들
                    .anyRequest().permitAll()
                .and()
                    //로그아웃 성공시 "/" 주소로 이동
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    //Oauth2 로그인 설정
                    .oauth2Login()
                        .userInfoEndpoint()
                            //소셜 로그인 성공 후 후속 조치를 진행할 UserService 인터페이스 구현체 등록
                            .userService(customOAuth2UserService);
    }
}