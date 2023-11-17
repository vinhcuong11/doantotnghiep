package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Accounts; 
import com.poly.service.AccountService;
 

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accService;
	
	@GetMapping()
	public List<Accounts> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if (admin.orElse(false)) {
			return accService.getAdministartors();
		}
		return accService.findAll();
	}
	
}
