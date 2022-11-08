package com.board.shopingboard.domain;

import com.board.shopingboard.controller.form.ProductSaveForm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String product_name;
    private Long product_price;
    private Long product_stock;
    private String product_detail;

    public class product{}

    @Enumerated(EnumType.STRING)
    private ProductSellStatus productSellStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;


    public Product(ProductSaveForm form, Member chkByUserId) {
        this.product_name = form.getProduct_name();
        this.product_price = form.getProduct_price();
        this.product_stock = form.getProduct_stock();
        this.product_detail = form.getProduct_detail();
        this.productSellStatus = form.getProductSellStatus();
        this.member = chkByUserId;
    }

}