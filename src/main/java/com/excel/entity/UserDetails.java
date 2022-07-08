package com.excel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	private Double id;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private Double age;
	private String date;

	public UserDetails() {
		super();
	}

	public UserDetails(Double id, String firstName, String lastName, String gender, String country, Double age,
			String date) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.age = age;
		this.date = date;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", country=" + country + ", age=" + age + ", date=" + date + "]";
	}
	
	

}
