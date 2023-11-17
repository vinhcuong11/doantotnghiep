package com.poly.entity;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="authori", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"user_id", "role_id"})})
public class Authories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idAuthori;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	Accounts acc;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Role roles;
}
