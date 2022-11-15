package com.board.shopingboard.controller.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class OrderSaveForm {
//*장바구니에서 오른쪽 하단부분에 <결제하기> 버튼을 누르면
//*(구매자 정보)가 나오고 거기에 *(주소)를 입력할수있게 하고

    @NotEmpty(message = "주소를 입력해주세요")
    private String address;

    @NotEmpty(message = "핸드폰 번호를 입력해주세요")
    private String phoneNumber;




}
