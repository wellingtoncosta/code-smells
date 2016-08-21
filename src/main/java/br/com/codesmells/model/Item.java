package br.com.codesmells.model;

public class Item {

	private String description;
	private double price;
	
	
	public Item(String description, Double price) {
		this.description 	= description;
		this.price 			= price;
	}	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}	
}