package com.board.shopingboard.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberSaveForm {

    //회원이름
    @NotEmpty(message = "정보를 입력해주세요")
    private String username;

    //회원정보
    @NotEmpty(message = "정보를 입력해주세요")
    private String userId;

    @NotEmpty(message = "정보를 입력해주세요")
    private String password;

    @NotEmpty(message = "정보를 입력해주세요")
    private String passwdchk;

    //주소 정보
    @NotEmpty(message = "정보를 입력해주세요")
    private String address;
}

