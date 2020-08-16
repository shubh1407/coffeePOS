package com.coffeePos;

public class Drinks extends Items{

	public Drinks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drinks(String name, double price, int quantity) {
		super(name, price, quantity,"Drinks");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Drinks [getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity()+"]";
	}	
}
