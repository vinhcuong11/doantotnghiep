package com.poly.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Categorys;
import com.poly.entity.Products;
import com.poly.service.CategotyService;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/foodshop/product")
public class ProductController {
	@Autowired
	CategotyService cService;
	@Autowired
	ProductService pService;

//	@GetMapping("")
//	public String getAll(
//			Model model, 
//			@RequestParam("cid")Optional<String> cid,
//			@Param("keyword")String keyword,
//			@RequestParam("min")Optional<Double> min,
//			@RequestParam("max")Optional<Double> max,
//			@RequestParam(name = "pageno", defaultValue = "1") Integer pageno
//			) {
//		
//		List<Categorys> lscate = cService.findAll();
//		 model.addAttribute("cates",lscate);
//		
////		if (cid.isPresent()) {
////			List<Products> ls = pService.findByCategory(cid);
////			model.addAttribute("item", ls);
////			return "product/list";
////		}else if(keyword != null) {
////			List<Products> ls = pService.findAllByName(keyword);
////			model.addAttribute("keyword", keyword);
////			model.addAttribute("item", ls);
////			return "product/list";
////		}else if(min != null && max != null) {
////			double minPrice = min.orElse(Double.MIN_VALUE);
////			double maxPrice = max.orElse(Double.MAX_VALUE);
////			List<Products> ls = pService.findAllByPriceBetweenMinAndMax(minPrice, maxPrice);
////			
////			model.addAttribute("min", minPrice);
////			model.addAttribute("max", maxPrice);
////			model.addAttribute("item", ls);
////			return "product/list";
////		}
////		else {
////			List<Products> ls = pService.findAll();
////			model.addAttribute("item", ls);
////			return "product/list";
////		}
//
//		 Page<Products> ls = pService.finAll(pageno, 9);
//			model.addAttribute("item", ls);
//			model.addAttribute("totalPage", ls.getTotalPages());
//			model.addAttribute("currenPage", pageno);
//			model.addAttribute("numberItem", ls.getNumberOfElements());
//			return "product/list";
//	 
//	}
//
//	@GetMapping("")
//	public String getAll(Model model,
//			 @Param("keyword") String keyword,
//			@RequestParam(name = "pageno", defaultValue = "1") Integer pageno) {
//
//		List<Categorys> lscate = cService.findAll();
//		model.addAttribute("cates", lscate);
//
//		if (keyword!=null) {
//			Page<Products> ls = pService.findAllByKeyword(keyword, (pageno), 6);
//			model.addAttribute("keyword", keyword);
//			model.addAttribute("item", ls);
//			model.addAttribute("totalPage", ls.getTotalPages());
//			model.addAttribute("currenPage", pageno);
//			model.addAttribute("numberItem", ls.getNumberOfElements());
//			return "product/list";
//		}else {
//			Page<Products> ls = pService.finAll(pageno, 9);
//		model.addAttribute("item", ls);
//		model.addAttribute("totalPage", ls.getTotalPages());
//		model.addAttribute("currenPage", pageno);
//		model.addAttribute("numberItem", ls.getNumberOfElements());
//		return "product/list";
//		}
//		
//	}

	@GetMapping("/THIT")
	public String getCategoryTHIT(Model model, @RequestParam("cid") Optional<String> cid,

			@RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max,
			@Param("keyword") String keyword, @RequestParam(name = "pageno", defaultValue = "1") Integer pageno) {

		List<Categorys> lscate = cService.findAll();
		model.addAttribute("cates", lscate);
		if (cid.isPresent()) {
			Page<Products> ls = pService.findByCategory(cid, pageno, 6);
			model.addAttribute("itemT", ls);
			model.addAttribute("totalPageT", ls.getTotalPages());
			model.addAttribute("currenPageT", pageno);
			model.addAttribute("numberItemT", ls.getNumberOfElements());
			return "product/THIT/list";
		} else if (keyword != null) {
			Page<Products> ls = pService.findAllByKeyword(keyword, (pageno), 6);
			model.addAttribute("keyword", keyword);
			model.addAttribute("itemT", ls);
			model.addAttribute("totalPageT", ls.getTotalPages());
			model.addAttribute("currenPageT", pageno);
			model.addAttribute("numberItemT", ls.getNumberOfElements());
			return "product/THIT/list";
		} else if (min != null && max != null) {
			double minPrice = min.orElse(Double.MIN_VALUE);
			double maxPrice = max.orElse(Double.MAX_VALUE);
////		List<Products> ls = pService.findAllByPriceBetweenMinAndMax(minPrice, maxPrice);
			Page<Products> ls = pService.findAllByPriceBetweenMinAndMax(minPrice, maxPrice, (pageno-1));
			model.addAttribute("min", minPrice);
			model.addAttribute("max", maxPrice);
			model.addAttribute("itemT", ls);
			model.addAttribute("totalPageT", ls.getTotalPages());
			model.addAttribute("currenPageT", pageno);
			model.addAttribute("numberItemT", ls.getNumberOfElements());
			return "product/THIT/list";
		} else {
			return "redirect:/product/list";
		}

	}

	@GetMapping("/HAISAN")
	public String getCategoryHAISAN(Model model, @RequestParam("cid") Optional<String> cid,
			@Param("keyword") String keyword,
			@RequestParam(name = "pageno", defaultValue = "1") Integer pageno) {

		List<Categorys> lscate = cService.findAll();
		model.addAttribute("cates", lscate);
		if (cid.isPresent()) {
			Page<Products> ls = pService.findByCategory(cid, pageno, 6);
			model.addAttribute("itemH", ls);
			model.addAttribute("totalPageH", ls.getTotalPages());
			model.addAttribute("currenPageH", pageno);
			model.addAttribute("numberItemH", ls.getNumberOfElements());
			return "product/HAISAN/list";
		}else if(keyword!=null) {
				Page<Products> ls = pService.findAllByKeyword(keyword, pageno, 6);
				model.addAttribute("keyword",keyword);
				model.addAttribute("itemH",ls);
				model.addAttribute("totalPageH", ls.getTotalPages());
				model.addAttribute("currenPageH", pageno);
				model.addAttribute("numberItemH", ls.getNumberOfElements());
				return "product/HAISAN/list";
		} else {
			return "redirect:/product/list";
		}

	}

	@GetMapping("/RAU")
	public String getCategoryRAU(Model model, @RequestParam("cid") Optional<String> cid,
			@Param("keyword") String keyword,
			@RequestParam(name = "pageno", defaultValue = "1") Integer pageno) {

		List<Categorys> lscate = cService.findAll();
		model.addAttribute("cates", lscate);
		if (cid.isPresent()) {
			Page<Products> ls = pService.findByCategory(cid, pageno, 6);
			model.addAttribute("itemR", ls);
			model.addAttribute("totalPageR", ls.getTotalPages());
			model.addAttribute("currenPageR", pageno);
			model.addAttribute("numberItemR", ls.getNumberOfElements());
			return "product/RAU/list";
		}else if(keyword!=null) {
			Page<Products> ls = pService.findAllByKeyword(keyword, pageno, 6);
			model.addAttribute("keyword",keyword);
			model.addAttribute("itemR",ls);
			model.addAttribute("totalPageR", ls.getTotalPages());
			model.addAttribute("currenPageR", pageno);
			model.addAttribute("numberItemR", ls.getNumberOfElements());
			return "product/RAU/list";
	} else {
			return "redirect:/product/list";
		}

	}

	@GetMapping("/QUA")
	public String getCategoryQUA(Model model, @RequestParam("cid") Optional<String> cid,
			@Param("keyword") String keyword,@RequestParam(name = "pageno", defaultValue = "1") Integer pageno) {

		List<Categorys> lscate = cService.findAll();
		model.addAttribute("cates", lscate);
		if (cid.isPresent()) {
			Page<Products> ls = pService.findByCategory(cid, pageno, 6);
			model.addAttribute("itemQ", ls);
			model.addAttribute("totalPageQ", ls.getTotalPages());
			model.addAttribute("currenPageQ", pageno);
			model.addAttribute("numberItemQ", ls.getNumberOfElements());
			return "product/QUA/list";
		} else {
			return "redirect:/product/list";
		}

	}

	@GetMapping("/detail/{id}")
	public String getDetail(Model model, @PathVariable("id") Integer id) {
		Products item = pService.getOne(id);
		model.addAttribute("items", item);
		return "product/detail-product";
	}

}
