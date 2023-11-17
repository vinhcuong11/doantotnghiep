package com.poly.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Products {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	Integer productid;
	String image;
	String name;
	Double price;
	Integer quantity;
	@ManyToOne
	@JoinColumn(name="category_id")
	Categorys category;
	Date createdate;
	String mass;
	Integer Numbermass;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderdetails;
}
