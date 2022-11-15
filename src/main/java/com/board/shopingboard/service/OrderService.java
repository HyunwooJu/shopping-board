package com.board.shopingboard.service;

import com.board.shopingboard.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final ProductCartRepository productCartRepository;

    //장바구니에 있는 상품 정보 및 회원정보를 가져와야 한다.
    public void totalProductCartOrder() {
//        productCartRepository
    }
}
