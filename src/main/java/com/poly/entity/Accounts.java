package com.poly.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account", schema = "foodshopdemo", catalog = "")
@Getter
@Setter
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer accid;
	String name;
	String username;
	String password;
	String email;
	String image;
	@Column(name = "phone_number")
	Integer phoneNumber;

}
