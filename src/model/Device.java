package model;

import java.io.Serializable;

public class Device implements Serializable{

	private String name;
	private int price;
	private String type;

	public Device(String name, int price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type + ":  " + name + ", price = " + price + "$";
	}
}
