package com.poly.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="account")
@Data
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer accid;
	String name;
	String username;
	String password;
	String email;
	String image;
	Integer phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Authories> authori;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Orders> order;
	
}
