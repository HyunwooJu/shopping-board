package com.board.shopingboard.service;

import com.board.shopingboard.controller.form.ProductSaveForm;
import com.board.shopingboard.domain.Member;
import com.board.shopingboard.domain.Product;
import com.board.shopingboard.repository.MemberRepository;
import com.board.shopingboard.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public void join(ProductSaveForm form, String sessionUser_id, MultipartFile productImage) throws IOException { //데이터가 담긴 그릇, 세션 유저의 이름

        String oriImgName = productImage.getOriginalFilename();
        String imgName = "";

//        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/image/";
        String projectPath = "C:/Users/HOME/Desktop/spring_img/";
        UUID uuid = UUID.randomUUID();

        imgName = uuid + "_" + oriImgName; //파일명 -> imageName

        File saveFile = new File(projectPath, imgName);

        productImage.transferTo(saveFile);

        Member chkByUserId = findMember(sessionUser_id);
        Product product = new Product(form, chkByUserId, imgName);

        productRepository.save(product); //DB에 저장된다.
    }

    public Member findMember(String sessionUser_id) {
        return memberRepository.findChkByUserId(sessionUser_id);
    }

    public List<Product> findProduct() {
        List<Product> findProductAll = productRepository.findAll();
        return findProductAll;
    }

}


