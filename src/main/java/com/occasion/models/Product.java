package com.occasion.models;

public class Product {

	int id;
	String name;
	String image;
	float price;
	String description;
	int owner;
	int category;
	
	public Product(String name,String image, float price, String description, int owner, int category) {
		super();
		this.name=name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.owner = owner;
		this.category = category;
	}
	
	public Product(int id, String name, String image, float price, String description, int owner, int category) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.owner = owner;
		this.category = category;
	}

	public Product() {
		// TODO Auto-generated constructor stub
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
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
