package com.board.shopingboard.domain;

import com.board.shopingboard.controller.form.ProductSaveForm;
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

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Product_Basket> product_baskets = new ArrayList<>();

    public Product(ProductSaveForm form, Member chkByUserId) {
        this.product_name = form.getProduct_name();
        this.product_price = form.getProduct_price();
        this.product_stock = form.getProduct_stock();
        this.product_detail = form.getProduct_detail();
        this.productSellStatus = form.getProductSellStatus();
        this.member = chkByUserId;
    }

}