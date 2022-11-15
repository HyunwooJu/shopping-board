package com.board.shopingboard.service;

import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product_Cart;
import com.board.shopingboard.repository.MemberRepository;
import com.board.shopingboard.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final ProductCartRepository productCartRepository;
    private final MemberRepository memberRepository;

    //장바구니에 있는 상품 정보 및 회원정보를 가져와야 한다.
    public List<Product_Cart> totalProductCartOrder(String username) {
        Member findMember = memberRepository.findChkByUserId(username);
        List<Product_Cart> findAllProductCart = productCartRepository.findByMemberId(findMember.getId());

        return findAllProductCart;
    }

    public Member findMember(String username) {
        Member findMember = memberRepository.findChkByUserId(username);
        return findMember;
    }
}
