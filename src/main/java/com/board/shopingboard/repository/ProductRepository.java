package com.board.shopingboard.repository;

import com.board.shopingboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
