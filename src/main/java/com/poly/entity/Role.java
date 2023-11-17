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

@Data
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "roles")
	List<Authories> authori;
}
