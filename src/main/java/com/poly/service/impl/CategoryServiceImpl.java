package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Categorys;
import com.poly.service.CategotyService;

@Service
public class CategoryServiceImpl implements CategotyService{

	@Autowired
	CategoryDAO cdao;
	@Override
	public List<Categorys> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

}
