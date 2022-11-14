package com.board.shopingboard.controller;

import com.board.shopingboard.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Controller
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cart")
public class ProductCartController {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;


}
