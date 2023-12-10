package com.poly.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderdetail")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@JoinColumn(name="delivery_address")
	String deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	Products product;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Orders order;
}
