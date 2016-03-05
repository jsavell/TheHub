package com.shadowaterservices.thehub.data.entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
public class HubUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6002884806320491461L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String lastName;
	
	private String firstName;
	
	public HubUser(String username, String password, Collection<GrantedAuthority> authorities, String lastName, String firstName) {
		super(username,password,authorities);
		this.setLastName(lastName);
		this.setFirstName(firstName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
