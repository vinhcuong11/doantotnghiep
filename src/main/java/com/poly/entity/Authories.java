package com.poly.entity;

 


import lombok.Data;

import javax.persistence.*;

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
