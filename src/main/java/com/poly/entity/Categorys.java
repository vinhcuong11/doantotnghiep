package com.poly.entity;

import java.util.List; 

 

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name="category")
public class Categorys {
	@Id
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Products> product;
}
