package com.poly.dao;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Accounts;
import com.poly.entity.Authories;

 
public interface AuthoriDAO extends JpaRepository<Authories, Integer>{
	@Query("select a from Authories a where a.acc in ?1")
	List<Authories> authorities(List<Accounts> accounts);
	
}
