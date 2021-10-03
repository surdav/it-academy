package com.floristeria.controlador;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.modelo.dominio.Decoracion.Material;
import com.floristeria.modelo.dominio.Floristeria;
import com.floristeria.modelo.dominio.Producto;
import com.floristeria.modelo.dominio.Ticket;
import com.floristeria.modelo.servicio.TicketRepo;

public class FloristeriaControlador {

	private final TicketRepo ticketRepo = new TicketRepo();
	
	public Floristeria createFloristeria(String nomFloristeria) throws NoContentException {
		return new Floristeria(nomFloristeria);
	}
	
	public void addArbol(Floristeria floristeria, String name, double height, double price) throws NoContentException {
		floristeria.addTree(name, height, price);
	}
	
	public void addFlor(Floristeria floristeria, String name, String color, double price) throws NoContentException {
		floristeria.addFlower(name, color, price);
	}
	
	public void addDecoracion(Floristeria floristeria, String name, Material type, double price) throws NoContentException, WrongMaterialException {
		floristeria.addDecoration(name, type, price);
	}
	
	public void removerProducto(Floristeria floristeria, int id) throws NoContentException {
		floristeria.removeProduct(id);
	}
	
	public void getProductStock(Floristeria floristeria, String product) {
		floristeria.printStock(product);
	}
	
	public void getAllProductsStock(Floristeria floristeria) {
		floristeria.printStock();
	}
	
	public void getStockValue(Floristeria floristeria) {
		floristeria.totalStockValue();
	}
	
	public void createTicket(Floristeria floristeria, List<Producto> productosTicket) throws NoContentException {
		Ticket ticket = new Ticket(productosTicket);
		ticketRepo.addTicket(ticket);
		ticket.printTicket();
	}
	
	public void printAllTickets() {
		for (Ticket ticket : ticketRepo.getAllTickets()) {
			ticket.printTicket();
		}
	}
	
	public void getAllTicketsValue() {
		
		System.out.println("VALOR TOTAL DE VENTAS REALIZADAS: "+
				
		ticketRepo.getAllTickets().stream()
			.mapToDouble(Ticket::getTotalValue)
			.sum());
		
	}
	
	public boolean comprobarId(Floristeria floristeria, int id) {
		List<Integer> productosIds = floristeria.getAllProducts().stream()
				.map(Producto::getId)
				.collect(Collectors.toList());
		return productosIds.contains(id);
	}
	
	public int comprobarIndexLista(Floristeria floristeria, int id) {
		int indexLista = -1;
		int i = 0;
		for(Producto p: floristeria.getAllProducts()) {
			if (floristeria.getAllProducts().get(i).getId() == id) {
				indexLista = i;
			}
			i++;
		}
		return indexLista;
	}
}
