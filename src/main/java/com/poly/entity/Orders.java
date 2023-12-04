package com.poly.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
