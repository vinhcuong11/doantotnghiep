package com.poly.controller.client;

import com.poly.entity.Accounts;
import com.poly.service.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foodshop")
public class PageContoller {

	private static final Logger LOGGER = LoggerFactory.getLogger(PageContoller.class);
	@Autowired
	SessionDAO session;

	@GetMapping("")
	public String goHome(Model model) {
		Accounts khachHang = (Accounts) session.get("user");
		LOGGER.info("khachHang: "+khachHang);
		return "layout/home";
	}
}
