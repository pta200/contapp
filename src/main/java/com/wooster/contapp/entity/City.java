package com.wooster.contapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * City entity object
 * @author pta200
 *
 */

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="cityid")
	private UUID citId;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="province")
	private String province;

	@Column(name="country")
	private String country;

	public City() {
	}

	public City(String city, String state, String province, String country) {
		this.city = city;
		this.state = state;
		this.province = province;
		this.country = country;
	}

	public UUID getId() {
		return citId;
	}
	
	public void setId(UUID citId) {
		this.citId = citId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "City [citId=" + citId + ", city=" + city + ", state=" + state + ", province=" + province + ", country="
				+ country + ", getId()=" + getId() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getProvince()=" + getProvince() + ", getCountry()=" + getCountry() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
 
}