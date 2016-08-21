package br.com.codesmells.nonduplicatedcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import br.com.codesmells.model.Item;
import br.com.codesmells.model.Order;

public class NonDuplicatedCode {

	public void printOrder(Order order) {
		this.printOrderOnConsole(order);
		this.printOrderOnFile(order);
	}
	
	private void printOrderOnConsole(Order order) {
		System.out.println(this.createHeader());
		System.out.println(this.createOrderDetails(order));
		System.out.println(this.createItemsDetails(order));		
		System.out.println(this.createTotalOrder(order));
	}
	
	private void printOrderOnFile(Order order) {
		try {
			Path file = this.createFile();

			FileWriter fileWriter = new FileWriter(file.toFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(this.createHeader());
			bufferedWriter.write(this.createOrderDetails(order));
			bufferedWriter.write(this.createItemsDetails(order));
			bufferedWriter.write(this.createTotalOrder(order));
			
			bufferedWriter.close();
			fileWriter.close();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	private String createHeader() {
		StringBuilder header = new StringBuilder();
		
		header.append("*****************************************************\n");
		header.append("********************** PEDIDO ***********************\n");
		header.append("*****************************************************\n");
		
		return header.toString();
	}
	
	private String createOrderDetails(Order order) {
		StringBuilder orderDetails = new StringBuilder();
		
		orderDetails.append(String.format("Pedido: %s \n", order.getName()));
		orderDetails.append(String.format("Data: %s \n\n", order.getDate()));
		
		return orderDetails.toString();
	}
	
	private String createItemsDetails(Order order) {
		List<Item> items = order.getItems();
		StringBuilder itemsDetails = new StringBuilder();
		
		itemsDetails.append("*********************** ITENS ***********************\n\n");
		
		for(Item item : items) { 
			itemsDetails.append(String.format("Item: %s \n", item.getDescription()));
			itemsDetails.append(String.format("Preco: %1$.2f \n", item.getPrice()));
			itemsDetails.append("-----------------------------------------------------\n");
		}
		
		return itemsDetails.toString();
	}
	
	private String createTotalOrder(Order order) {
		return String.format("\nTotal: %1$.2f",  order.getTotal());
	}
	
	private Path createFile() {
		String homePath = System.getProperty("user.home");
		String fileName = "pedido-" + UUID.randomUUID() + ".txt";
		
		return Paths.get(homePath + "/" + fileName);
	}
}