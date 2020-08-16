package com.coffeePos;

public abstract class Items {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public Items(String name, double price, int quantity,String category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category=category;
	}
	private double price;
	private int quantity;
	private String category;
	public String getCategory() {
		return category;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
