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
    @Column(name="member_id")
    private Long id; //DB id

    private String userId; //유저 아이디
    private String password; //유저 비밀번호
    private String username; //유저 이름

    private String address; //유저 주소

    private String role; //ROLE_USER, ROLE_ADMIN

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Product_Cart> product_carts = new ArrayList<>();


    public Member(MemberSaveForm form) {
        this.username = form.getUsername();
        this.userId = form.getUserId();
        this.password = form.getPassword();
    }

    public Member(String username, String userId, String password, String role) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }
}
