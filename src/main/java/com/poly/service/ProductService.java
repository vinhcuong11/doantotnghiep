package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poly.entity.Products;

public interface ProductService  {
	Page<Products> findAll(Integer pageNo);
	
	
	List<Products> findByCategory(Optional<String> cid);
	List<Products> findAllByName(String keyword);
	
	List<Products> findAllByPriceBetweenMinAndMax(Double min, Double max);
	
//	Page<Products> findAllByKeyword(String keyword,Integer pageNo);
	
	Page<Products> finAll(int pageNo, int pageSize);
	
	Page<Products> findByCategory(Optional<String> cid, int pageNo, int pageSize);
	
	Page<Products> findAllByKeyword(String keyword, int pageNo, int pageSize);
	
	Page<Products> findAllByPriceBetweenMinAndMax(Double min, Double max, int pageNo);
	
	List<Products> findAll();
	Products getOne(Integer id);

	Products create(Products product);

	Products update(Products product);

	void delete(Integer id);

	
}
