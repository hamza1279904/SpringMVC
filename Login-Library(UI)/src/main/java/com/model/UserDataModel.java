package com.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Data")
public class UserDataModel {

	@Id
	@Column(name = "Username")
	private String username = null;

	@Column(name = "password")
	private String password = null;

	public UserDataModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;

	}

	UserDataModel() {
		this.password = null;
		this.username = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return (String) password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
