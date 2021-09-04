package com.occasion.models;

public class ResSearch {

	String name;
	String image;
	float price;
	String description;
	private String city;
	private String firstName;
	private String lastName;
	private String tel;
	
	
	public ResSearch(String name, String image, float price, String description, String city, String firstName,
			String lastName, String tel) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
}
