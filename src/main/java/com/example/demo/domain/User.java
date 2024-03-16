package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String name;
	private String email;
	
	public User() {
	}

	public User(String _id, String _name, String _email) {
		super();
		id = _id;
		name = _name;
		email = _email;
	}

	public String getId() {
		return id;
	}

	public void setId(String _id) {
		id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		email = _email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
