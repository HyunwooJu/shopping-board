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
            ProductSaveForm productSaveForm1 = new ProductSaveForm("프로틴", 11111L, "프로틴입니다", 100L, ProductSellStatus.SELL);
            ProductSaveForm productSaveForm2 = new ProductSaveForm("반팔티", 22222L, "여름반파티입니다.", 200L, ProductSellStatus.SELL);
            Product product1 = new Product(productSaveForm1, member, "545d8543-067d-4e18-ba67-f33d9471f428_코로나 양성 확인서.jpg");
            Product product2 = new Product(productSaveForm2, member, "950e498f-399e-4fb8-adb3-1fdce756216a_코로나 양성 확인서.jpg");
            em.persist(member);
            em.persist(product1);
            em.persist(product2);
        }

    }
}
