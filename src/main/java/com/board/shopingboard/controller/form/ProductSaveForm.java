package com.board.shopingboard.controller.form;

import com.board.shopingboard.domain.ProductSellStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductSaveForm {

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String product_name;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Long product_price;

    @NotBlank(message = "상품 상세는 필수 입력 값입니다.")
    private String product_detail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Long product_stock;

    private ProductSellStatus productSellStatus;

    public ProductSaveForm(String product_name, Long product_price, String product_detail, Long product_stock, ProductSellStatus productSellStatus) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_detail = product_detail;
        this.product_stock = product_stock;
        this.productSellStatus = productSellStatus;
    }
}