package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.entity.Products;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO pdao;
	
	

	@Override
	public List<Products> findAllByName(String keyword) {
		// TODO Auto-generated method stub
		return pdao.findAllByName(keyword);
	}



	@Override
	public Page<Products> findAll(Integer pageNo) {
		 Pageable pageable = PageRequest.of(pageNo - 1, 6);
		return pdao.findAll(pageable);
	}



	@Override
	public Page<Products> findAllByKeyword(String keyword, Integer pageNo) {
		List ls = this.findAllByName(keyword);
		
		Pageable pageable = PageRequest.of(pageNo-1, 4);
		
		Integer start = (int) pageable.getOffset();
		
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > ls.size() ? ls.size() : pageable.getOffset() + pageable.getPageSize());
		
		ls = ls.subList(start, end);
		
		return new PageImpl<Products>(ls,pageable,this.findAllByName(keyword).size());
	}



	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}



	@Override
	public Products getOne(Integer id) {
		// TODO Auto-generated method stub
		return pdao.getOne(id);
	}



	@Override
	public Products create(Products product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}



	
	
	@Override
	public Products update(Products product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}



	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		pdao.deleteById(id);;
	}

	

	 

	

	 

	 

	 
 
	 

}
