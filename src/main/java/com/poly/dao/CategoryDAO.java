package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Categorys;

public interface CategoryDAO extends JpaRepository<Categorys, String> {

}
