package com.board.shopingboard.service;

import com.board.shopingboard.config.auth.PrincipalDetails;
import com.board.shopingboard.controller.form.ItemSaveForm;
import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product;
import com.board.shopingboard.domain.Product_Cart;
import com.board.shopingboard.repository.MemberRepository;
import com.board.shopingboard.repository.ProductCartRepository;
import com.board.shopingboard.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ProductRepository productRepository;
    private final ProductCartRepository productCartRepository;
    private final MemberRepository memberRepository;

    public Product findItemById(Long itemId, PrincipalDetails principalDetails) {
        Product findProduct = productRepository.findById(itemId).orElse(null);
        return findProduct;
    }

    @Transactional
    public void itemCartSave(Long itemId, ItemSaveForm itemSaveForm, PrincipalDetails principalDetails) {
        Member findMember = memberRepository.findChkByUserId(principalDetails.getUsername());
        Product findProduct = productRepository.findById(itemId).orElse(null);


        Product_Cart product_cart = new Product_Cart(findProduct, itemSaveForm.getProductCartStock(), findMember);

        productCartRepository.save(product_cart);
    }

    public List<Product_Cart> itemList() {
        List<Product_Cart> itemAll = productCartRepository.findAll();


        return itemAll;
    }

}
