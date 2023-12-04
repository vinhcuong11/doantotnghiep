package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDAO;
import com.poly.entity.Orders;
import com.poly.service.OrderService;

@Service
public class OrderServiceIml implements OrderService{

	@Autowired
	OrderDAO odao;
	
	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}

}
