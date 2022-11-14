package com.board.shopingboard.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ItemSaveForm {

    @NotEmpty
    private Long productCartStock;

}

