package com.poly.service;

import java.util.List;

import com.poly.entity.Accounts;

public interface AccountService {
	List<Accounts> findAll();

	List<Accounts> getAdministartors();

	Accounts getUser(String userName);

	void SaveAccount(Accounts accounts) throws Exception;
}
