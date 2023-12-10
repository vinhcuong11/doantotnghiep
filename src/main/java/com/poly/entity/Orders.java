package com.poly.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="orderId")
	Integer orderid;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	@JoinColumn(name="orderDate")
	Date orderdate = new Date();
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	@JoinColumn(name="deliverydate")
	Date deliverydate = new Date();
	
	Boolean status = false;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Accounts acc;
	
	@JsonIgnore
	@OneToOne(mappedBy = "order")
	OrderDetails orderdetails;
}
