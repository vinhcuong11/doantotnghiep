package com.poly.entity;




import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(name = "role_name")
	String roleName;
}
