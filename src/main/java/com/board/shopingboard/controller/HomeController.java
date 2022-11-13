package com.board.shopingboard.controller;


import com.board.shopingboard.domain.Product;
import com.board.shopingboard.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/main")
    public String main(Model model) {
        List<Product> product = productService.findProduct();

        model.addAttribute("productAll", product);
        return "main";
    }

}
