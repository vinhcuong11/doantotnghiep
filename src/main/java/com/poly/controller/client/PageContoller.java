package com.poly.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foodshop")
public class PageContoller {
	@GetMapping("")
	public String goHome() {
		return "layout/home";
	}
}
