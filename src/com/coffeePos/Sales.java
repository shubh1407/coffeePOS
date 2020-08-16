package com.coffeePos;

import java.sql.Date;

public class Sales {
	
	private String name;
	private double price;
	private int quantity;
	private Date salesDate;
	private double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Sales [name=" + name + ", price=" + price + ", quantity=" + quantity + ", salesDate=" + salesDate
				+ ", amount=" + amount + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sales(String name, double price, int quantity, Date salesDate,double amount) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.salesDate = salesDate;
		this.amount=amount;
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
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
	

}
