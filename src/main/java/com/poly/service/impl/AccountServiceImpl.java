package com.poly.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Accounts;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO accdao;
	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return accdao.findAll();
	}
	@Override
	public List<Accounts> getAdministartors() {
		// TODO Auto-generated method stub
		return accdao.getAdministartors();
	}

}
