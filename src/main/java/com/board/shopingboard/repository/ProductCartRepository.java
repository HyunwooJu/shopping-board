package com.board.shopingboard.repository;

import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product_Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<Product_Cart, Long> {

    public List<Product_Cart> findByMemberId(Long memberId);
}