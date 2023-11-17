package com.poly.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.poly.dao.AuthoriDAO;
import com.poly.dao.RoleDAO;
import com.poly.entity.Authories;
import com.poly.entity.Role;
import com.poly.service.AuthoriService;
import com.poly.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
	@Autowired
	RoleDAO rdao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rdao.findAll();
	}

}
