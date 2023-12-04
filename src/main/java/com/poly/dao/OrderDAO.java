package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Orders;

public interface OrderDAO extends JpaRepository<Orders, Integer>{

}
