package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "foodshopdemo", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer accid;
//	Integer roleid;
	String name;
	String username;
	String password;
	String email;
	String image;
	@Column(name = "phone_number")
	Integer phoneNumber;

	// Khoa Ngoai
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "roleid", referencedColumnName = "id")
	@JoinColumn(name="roleid",referencedColumnName="id", insertable=false, updatable=false)
//	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Role role;

	@Override
	public String toString() {
		return "Accounts{" +
				"accid=" + accid +
				", name='" + name + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", image='" + image + '\'' +
				", phoneNumber=" + phoneNumber +
				", role=" + role +
				'}';
	}
}


