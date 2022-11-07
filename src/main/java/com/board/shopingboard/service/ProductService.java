package com.board.shopingboard.service;

import com.board.shopingboard.controller.form.ProductSaveForm;
import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product;
import com.board.shopingboard.repository.MemberRepository;
import com.board.shopingboard.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public void join(ProductSaveForm form, String sessionUser_id) { //데이터가 담긴 그릇, 세션 유저의 이름 

        Member chkByUserId = findMember(sessionUser_id);
        Product product = new Product(form, chkByUserId);

        productRepository.save(product); //DB에 저장된다.
    }

    public Member findMember(String sessionUser_id) {
        return memberRepository.findChkByUserId(sessionUser_id);
    }
}
