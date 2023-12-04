package com.poly.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart/view")
public class CartController {
	@GetMapping("")
	public String viewCart() {
		return "cart/view";
	}
}
