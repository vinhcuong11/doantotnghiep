package com.poly.controller.client;

import com.poly.entity.Accounts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foodshop")
public class PageContoller {
	@GetMapping("")
	public String goHome(Model model) {
		model.addAttribute("userRequest", new Accounts());
		return "layout/home";
	}
}
