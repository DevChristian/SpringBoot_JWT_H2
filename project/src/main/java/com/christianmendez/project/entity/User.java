package com.christianmendez.project.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY,generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID_USER")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CREATED")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date created;
	
	@Column(name = "MODIFIED")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date modified;

	@Column(name = "LAST_LOGIN")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date last_login;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "ISACTIVE")
	private Boolean isactive;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Phones> phones;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Set<Phones> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phones> phones) {
		this.phones = phones;
	}
	
}