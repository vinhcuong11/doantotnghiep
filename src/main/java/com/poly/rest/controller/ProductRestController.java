package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Products;
import com.poly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products/")
public class ProductRestController {
	
	@Autowired
	ProductService pService;
	
	@GetMapping()
	public List<Products> getAll() {
		return pService.findAll();
	}
	
	// localhost:8088/rest/admin/{id}	
	@GetMapping("{id}")
	public Products getAll(@PathVariable("id")Integer id) {
		return pService.getOne(id);
	}
	
	@PostMapping
	public Products create(@RequestBody Products product) {
		return pService.create(product);
	}
	@PutMapping("{id}")
	public Products update(@PathVariable("id") Integer  id,@RequestBody Products product) {
		return pService.update(product);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer  id) {
		 pService.delete(id);
	}
	
}
