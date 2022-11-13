package com.board.shopingboard.repository;

import com.board.shopingboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Long> {

}


