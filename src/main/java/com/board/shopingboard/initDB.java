package com.board.shopingboard;

import com.board.shopingboard.controller.form.ProductSaveForm;
import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product;
import com.board.shopingboard.domain.ProductSellStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;


    @PostConstruct
    public void init() {
        initService.dbInit1();

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;

        public void dbInit1() {
            Member member = new Member("관리자", "admin", bCryptPasswordEncoder.encode("admin"), "ROLE_ADMIN");
            ProductSaveForm productSaveForm1 = new ProductSaveForm("프로틴", 11111L, "프로틴 입니다", 999999L, ProductSellStatus.SELL);
            ProductSaveForm productSaveForm2 = new ProductSaveForm("반팔티", 22222L, "반팔티 입니다.", 999999L, ProductSellStatus.SELL);
            ProductSaveForm productSaveForm3 = new ProductSaveForm("단백질 바", 10000L, "프로틴 바 입니다.", 999999L, ProductSellStatus.SELL);
            Product product1 = new Product(productSaveForm1, member, "protein.jpg");
            Product product2 = new Product(productSaveForm2, member, "7973844940_l.jpg");
            Product product3 = new Product(productSaveForm3, member, "35g-24-GFCF.jpg_Q90.jpg");
            em.persist(member);
            em.persist(product1);
            em.persist(product2);
            em.persist(product3);
        }

    }
}
