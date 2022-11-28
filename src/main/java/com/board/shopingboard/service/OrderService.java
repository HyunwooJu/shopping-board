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

    private final ItemService itemService;

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

    @Transactional
    public Product_Cart joinOrder(String username) {
        Member findMember = memberRepository.findChkByUserId(username);
        Long memberOldUserPoint = findMember.getUser_point();

        log.info("memberOldUserPoing = {}", memberOldUserPoint);
        List<Product_Cart> itemCartListAll = itemService.itemList();

        Long productTotalPay = 0L;
        for (int i = 0; i < itemCartListAll.size(); i++) {
            Long price = itemCartListAll.get(i).getProduct().getProduct_price();
            Long stock = itemCartListAll.get(i).getProductCartStock();
            productTotalPay += (price * stock);
        }
        productTotalPay = productTotalPay / 10;
        Long memberNewUserPoint = memberOldUserPoint + productTotalPay;

        findMember.setUser_point(memberNewUserPoint);

        Product_Cart findProduct = productCartRepository.findChkByMemberId(findMember.getId());

        return findProduct;

    }

}
