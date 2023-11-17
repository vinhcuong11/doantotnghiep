package com.poly.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Products;
import com.poly.service.ProductService;

@Controller

public class AdminController {


	@RequestMapping({"/admin/home"})
	public String getPageAdmin() {
		return "redirect:/assets/admin/index.html";
	}

	@RequestMapping("/admin/product-list")
	public String getListProduct() {
		
//		Model model,@RequestParam(name="pageNo", defaultValue = "1") Integer paggeNo ,@Param("keyword") String keyword
//			
//		Page<Products> ls = pService.findAll(paggeNo);
//		
//		if (keyword != null ) {
//			ls= this.pService.findAllByKeyword("%"+keyword+"%", paggeNo);
//			model.addAttribute("keyword",keyword);
//		}
//		
//		model.addAttribute("totalPages", ls.getTotalPages());
//		model.addAttribute("currentPage", paggeNo);
//		model.addAttribute("amountItem", ls.getNumberOfElements());
//		model.addAttribute("totalItem", ls.getTotalElements());
//		model.addAttribute("ls",ls);
//		if (p != null) {
//			pageable = PageRequest.of(p, 8);
//
//			Page<Products> page = pService.findAll(pageable);
//			model.addAttribute("ls", page);
//			model.addAttribute("currentPage", p);
//
//			int amountItems = page.getNumberOfElements();
//			long totalItems = page.getTotalElements();
//			int totalPages = page.getTotalPages();
//
//			model.addAttribute("totalItems", totalItems);
//			model.addAttribute("amountItems", amountItems);
//			model.addAttribute("totalPages", totalPages);
//		}

		// List<Products> ls = pService.findAll();
//		if (keyword != null ) {
//			ls= this.pService.findAllByName(keyword);
//		}
//		model.addAttribute("item",ls);

		return "redirect:/assets/admin/product/listProduct.html";
	}
	
	@RequestMapping({"/admin/account/list"})
	public String getPageAccount() {
		return "redirect:/assets/admin/account/listaccount.html";
	}
}
