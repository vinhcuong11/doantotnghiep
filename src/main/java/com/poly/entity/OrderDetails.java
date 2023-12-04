package com.poly.entity;

 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

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
