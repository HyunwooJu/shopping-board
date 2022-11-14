package com.board.shopingboard.repository;

import  com.board.shopingboard.domain.Product_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductCartRepository extends JpaRepository<Product_Cart, Long>{

}