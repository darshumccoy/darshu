package com.mccoy.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="emp_table")
public class LoginDto implements Serializable {
	public LoginDto() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Id
	@GenericGenerator(name="my_id",strategy="increment")
	@GeneratedValue(generator="my_id")
	@Column(name="e_id")
	private int id;
	
	@Column(name="e_name")
	private String name;
	@Column(name="e_email")
	@NotEmpty
	@Email
	private String email;
	@Column(name="e_pass")
	@NotEmpty(message = "Please enter your password.")
	private String pass;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
