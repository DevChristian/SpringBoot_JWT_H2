package com.christianmendez.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PHONES")
public class Phones {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY,generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column( name = "ID_PHONES")
	private String id;
	
	@Column( name = "NUMBER")
	private int number;
	
	@Column( name = "CITY_CODE")
	private int citycode;
	
	@Column( name = "COUNTRY_CODE")
	private int countrycode;
	
	@Column( name = "ID_USER")
	private String id_user;
	

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	
}