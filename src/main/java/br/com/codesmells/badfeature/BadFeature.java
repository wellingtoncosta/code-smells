package br.com.codesmells.badfeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import br.com.codesmells.model.Item;
import br.com.codesmells.model.Order;

public class BadFeature {

	public void printOrder(Order order) {
		System.out.print("*****************************************************\n");
		System.out.print("********************** PEDIDO ***********************\n");
		System.out.print("*****************************************************\n\n");
		
		System.out.print(String.format("Pedido: %s \n", order.getName()));
		System.out.print(String.format("Data: %s \n\n", order.getDate()));
		
		System.out.print("*********************** ITENS ***********************\n\n");
		
		List<Item> items = order.getItems();
		
		for(Item item : items) {
			System.out.println("Item: " + item.getDescription());
			System.out.println("Preco: " + item.getPrice());
			System.out.print("-----------------------------------------------------\n");
		}
		
		System.out.println();
		System.out.println("Total: " + order.getTotal());

		try {
			String homePath = System.getProperty("user.home");
			String fileName = "pedido-" + UUID.randomUUID() + ".txt";
			
			Path path = Paths.get(homePath + "/" + fileName);

			FileWriter fileWriter = new FileWriter(path.toFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("*****************************************************\n");
			bufferedWriter.write("******************** NOTA FISCAL ********************\n");
			bufferedWriter.write("*****************************************************\n\n");
			
			bufferedWriter.write(String.format("Pedido: %s \n\n", order.getName()));
			
			bufferedWriter.write("*********************** ITEMS ***********************\n\n");
			
			for(Item item : items) {
				bufferedWriter.write("Item: " + item.getDescription());
				bufferedWriter.newLine();
				bufferedWriter.write("Preco: " + item.getPrice());
				bufferedWriter.newLine();
				bufferedWriter.write("-----------------------------------------------------\n");
			}
			
			bufferedWriter.newLine();
			bufferedWriter.write("Total: " + order.getTotal());
			
			bufferedWriter.close();
			fileWriter.close();
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}	
}