package com.board.shopingboard.domain;

import com.board.shopingboard.controller.form.MemberSaveForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; //DB id

    private String userId; //유저 아이디
    private String password; //유저 비밀번호
    private String username; //유저 이름

    private String address; //유저 주소

    private Long user_point; //유저 포인트


    private String role; //ROLE_USER, ROLE_ADMIN

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Product_Cart> product_carts = new ArrayList<>();

    /**
     * Member => Order
     * Member는 order에게 member의 정보를 던져줌
     * mappedBy = "member" ==> order의 member와 영속성을 지니고 있음.
     */
    @OneToOne(mappedBy = "member")
    private Order order;

    public Member(MemberSaveForm form) {
        this.username = form.getUsername();
        this.userId = form.getUserId();
        this.password = form.getPassword();
        this.address = form.getAddress();
        this.user_point = 0L;
    }

    public Member(String username, String userId, String password, String role, String address, Long user_point) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.address = address;
        this.user_point = user_point;
    }

}
