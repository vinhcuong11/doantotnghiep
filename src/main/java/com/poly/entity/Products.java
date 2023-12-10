package com.poly.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
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
	Boolean status;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderdetails;
}
