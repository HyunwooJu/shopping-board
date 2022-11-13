package com.board.shopingboard.controller;

import com.board.shopingboard.config.auth.PrincipalDetails;
import com.board.shopingboard.controller.form.ProductSaveForm;
import com.board.shopingboard.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/product/new")
    public String itemAdd(ProductSaveForm form, Model model) {

        model.addAttribute("productSaveForm", form);
        return "product/productForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/product/new")
    public String inventory(@Valid ProductSaveForm form, @AuthenticationPrincipal PrincipalDetails principalDetails, BindingResult result, MultipartFile productImage) throws IOException { //상품을 담고 있는 그릇, 로그인한 세션정보, 에러정보

        if (form.getProduct_name().length() == 1) {
            result.reject("productNameLengthTooShort", "제품명이 너무 짧습니다.");
            return "product/productForm";
        }

        if (form.getProduct_price() <= 10000) {
            result.reject("productPriceMinimum", "제품의 가격의 만원 이상이여야 합니다.");
            return "product/productForm";
        }

        if (result.hasErrors()) {
            return "product/productForm";
        }

        String sessionUser_id = principalDetails.getUsername();
        productService.join(form, sessionUser_id, productImage);

        return "redirect:/main";
    }
}
