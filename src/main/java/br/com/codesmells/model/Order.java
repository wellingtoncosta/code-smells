package br.com.codesmells.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private String name;
	private Date date;
	private List<Item> items;
	private double total;
	
	public Order(String name) {
		this.name = name;
		this.date = new Date();
		this.items = new ArrayList<Item>();
	}
	
	public Order(String name, Date date) {
		this.name = name;
		this.date = date;
		this.items = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
		this.total += item.getPrice();
	}
	
	public void removeItem(int index) {
		Item item = this.items.remove(index);
		this.total -= item.getPrice();
	}
	
	public double getTotal() {
		return total;
	}
}