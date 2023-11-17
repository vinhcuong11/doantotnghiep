package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Authories;
import com.poly.service.AuthoriService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authories")
public class AuthoriesRestController {

		@Autowired
		AuthoriService auService;
		
		@GetMapping()
		public List<Authories> findAll(@RequestParam("admin") Optional<Boolean> admin){
			if (admin.orElse(false)) {
					return auService.findAuthoriesOfAdministators();
			}
			return auService.findAll();
		}
}
