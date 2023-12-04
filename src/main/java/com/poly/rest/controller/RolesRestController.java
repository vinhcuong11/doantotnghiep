package com.poly.rest.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.poly.entity.Authories;
import com.poly.entity.Role;
import com.poly.service.AuthoriService;
import com.poly.service.RolesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RolesRestController {
	@Autowired
	RolesService rService;
	
	@GetMapping()
	public List<Role> getAll(){
		return rService.findAll();
	}
}
