package com.poly.entity;

import jakarta.persistence.*;
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
				'}';
	}
}
