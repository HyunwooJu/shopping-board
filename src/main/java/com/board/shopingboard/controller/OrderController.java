package com.board.shopingboard.controller;


import com.board.shopingboard.config.auth.PrincipalDetails;
import com.board.shopingboard.controller.form.OrderSaveForm;
import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product_Cart;
import com.board.shopingboard.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    public String orderForm(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

        List<Product_Cart> findAllProductCart = orderService.totalProductCartOrder(principalDetails.getUsername());
        Member findMember = orderService.findMember(principalDetails.getUsername());

        model.addAttribute("findAllProductCart", findAllProductCart);
        model.addAttribute("findMember", findMember);

        return "order/orderForm";
    }

}
