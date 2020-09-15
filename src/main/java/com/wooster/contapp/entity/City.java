package com.wooster.contapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
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
    
    
    
}
