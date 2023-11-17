package com.poly.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Products;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/foodshop/product")
public class ProductController {
	
	@Autowired
	ProductService pService;
	
	@GetMapping("/")
	public String getAll(Model model) {
		List<Products> ls = pService.findAll();
		model.addAttribute("item",ls);
		return "product/list";
	}
	@GetMapping("/detail/{id}")
	public String getDetail(Model model, @PathVariable("id")Integer id) {
		Products item = pService.getOne(id);
		model.addAttribute("items",item);
		return "product/detail-product";
	}

}
