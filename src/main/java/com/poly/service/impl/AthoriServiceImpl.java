package com.poly.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.dao.AuthoriDAO;
import com.poly.entity.Accounts;
import com.poly.entity.Authories; 
import com.poly.service.AuthoriService;

@Service
public class AthoriServiceImpl implements AuthoriService{
	@Autowired
	AuthoriDAO adao;
	
	@Autowired
	AccountDAO accdao;
	
	
	@Override
	public List<Authories> findAll() {
		// TODO Auto-generated method stub
		return adao.findAll();
	}
	@Override
	public Authories create(Authories authori) {
		// TODO Auto-generated method stub
		return adao.save(authori);
	}
	@Override
	public List<Authories> findAuthoriesOfAdministators() {
		List<Accounts> accounts = accdao.getAdministartors();
		return adao.authorities(accounts);
	}

}
