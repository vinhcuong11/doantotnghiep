package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

	// Khoa Ngoai
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleid", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
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


