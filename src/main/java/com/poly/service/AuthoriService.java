package com.poly.service;

import java.util.List; 

 
import com.poly.entity.Authories;

public interface AuthoriService {
	List<Authories> findAll();

	Authories create(Authories authori);

	List<Authories> findAuthoriesOfAdministators();
}
