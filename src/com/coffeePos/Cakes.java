package com.coffeePos;

public class Cakes extends Items{

	@Override
	public String toString() {
		return "Cakes [getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity()+"]";
	}

	public Cakes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cakes(String name, double price, int quantity) {
		super(name, price, quantity,"Cakes");
		// TODO Auto-generated constructor stub
	}
}
