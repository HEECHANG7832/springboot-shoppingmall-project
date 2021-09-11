package com.example.springbootshoppingmallproject.domain;

import com.example.springbootshoppingmallproject.domain.user.Role;
import com.example.springbootshoppingmallproject.domain.user.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void 카트저장_가져오기() {
//
//        //given
//        Product product = new Product();
//        product.setProductName("productName");
//
//        User user = new User("kwon", "facee22av@naver.com", "picture", Role.USER);
//
//        cartRepository.save(Cart.builder()
//                .productCount(0)
//                .product(product)
//                .user(user)
//                .build());
//
//        //when
//        List<Cart> cartList = cartRepository.findAll();
//
//        //then
//        Cart cart = cartList.get(0);
//        assertThat(cart.getProductCount()).isEqualTo(0);
//        assertThat(cart.getProduct().getProductName()).isEqualTo("productName");
//        assertThat(cart.getUser().getEmail()).isEqualTo("facee22av@naver.com");
    }

}
