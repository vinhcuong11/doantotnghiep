package com.poly.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/checkout")
public class OrderController {
	@GetMapping("")
	public String checkout() {
		return "order/checkout";
	}
	@GetMapping("/list")
	public String list() {
		return "order/list";
	}
	@GetMapping("/detail/{id}")
	public String detail() {
		return "order/detail";
	}
}
