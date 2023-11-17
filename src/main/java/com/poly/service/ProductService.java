package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Products;

public interface ProductService  {
	Page<Products> findAll(Integer pageNo);
	
	List<Products> findAllByName(String keyword);
	Page<Products> findAllByKeyword(String keyword,Integer pageNo);
	
	List<Products> findAll();
	Products getOne(Integer id);

	Products create(Products product);

	Products update(Products product);

	void delete(Integer id);

	
}
