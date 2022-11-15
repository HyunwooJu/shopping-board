package com.board.shopingboard.controller;


import com.board.shopingboard.controller.form.OrderSaveForm;
import com.board.shopingboard.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * 로그인된 회원의 장바구니 목록을 불러와야 한다.
     * Member
     * ProductCart
     */
    @GetMapping("/orders")
    public String orderForm(OrderSaveForm orderSaveForm, Model model) {
        orderService.totalProductCartOrder();
        
        return "order/orderForm";
    }

}
