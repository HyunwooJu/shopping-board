package com.board.shopingboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Product_Cart> product_carts = new ArrayList<>();


    /**
     * Order => Member
     * Order에 불러온 Member의 id값을 정의 할 때 order_member_id로 정의할 것이며
     * order_member_id는 상품을 주문한 member의 id를 저장할 것이다.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_member_id")
    private Member member;

}
