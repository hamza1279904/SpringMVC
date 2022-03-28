package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class AuthorNames {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id = 1;
	private String name = null;

	public AuthorNames(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public AuthorNames() {
		super();
	}

	@Override
	public String toString() {
		return "AuthorNames [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
