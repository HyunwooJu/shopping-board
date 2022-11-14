package com.board.shopingboard.controller;

import com.board.shopingboard.config.auth.PrincipalDetails;
import com.board.shopingboard.controller.form.ItemSaveForm;
import com.board.shopingboard.domain.Product;
import com.board.shopingboard.domain.Product_Cart;
import com.board.shopingboard.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/add")
    public String itemDetail(@RequestParam Long itemId, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        Product findByProduct = itemService.findItemById(itemId, principalDetails);

        model.addAttribute("findByProduct", findByProduct);
        model.addAttribute("itemSaveForm", new ItemSaveForm());

        return "item/itemDetail";
    }

    @PostMapping("/itemCart/add")
    public String itemCartAdd(@RequestParam Long itemId, @ModelAttribute("productCartStock") ItemSaveForm itemSaveForm, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        log.info("itemId가 왔는가?={}", itemId);
        log.info("stock값은?={}", itemSaveForm.getProductCartStock());

        itemService.itemCartSave(itemId, itemSaveForm, principalDetails);
        return "redirect:/main";
    }

    @GetMapping("/itemcart")
    public String itemCartList(Model model) {
        List<Product_Cart> itemCartListAll = itemService.itemList();

        Long productTotalPay = 0L;
        for (int i = 0; i < itemCartListAll.size(); i++) {
            Long price = itemCartListAll.get(i).getProduct().getProduct_price();
            Long stock = itemCartListAll.get(i).getProductCartStock();
            productTotalPay += (price * stock);
        }

        model.addAttribute("itemCartListAll", itemCartListAll);
        model.addAttribute("productTotalPay", productTotalPay);

        return "item/itemList";
    }

}
