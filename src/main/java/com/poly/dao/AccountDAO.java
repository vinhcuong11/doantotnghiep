package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, Integer>{

	@Query(value="select a.user_id  from authori a where a.role_id in ('1')", nativeQuery = true)
	List<Accounts> getAdministartors();

}
