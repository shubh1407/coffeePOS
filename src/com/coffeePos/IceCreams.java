package com.coffeePos;

public class IceCreams extends Items{

	@Override
	public String toString() {
		return "Ice-creams [getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity()+"]";
	}

	public IceCreams() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IceCreams(String name, double price, int quantity) {
		super(name, price, quantity,"IceCreams");
		// TODO Auto-generated constructor stub
	}
}
