package com.poly.entity;




import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Column(name = "role_name")
	String roleName;
	

}
