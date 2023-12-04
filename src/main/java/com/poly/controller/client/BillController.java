package com.poly.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("cart/wishlist")
public class BillController {
    @GetMapping("")
    public String viewBill() {
        return "cart/wishlist";
    }
}
