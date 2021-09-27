package com.floristeria.controlador;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.modelo.dominio.Floristeria;
import com.floristeria.modelo.dominio.Producto;
import com.floristeria.modelo.dominio.Ticket;
import com.floristeria.modelo.servicio.TicketRepo;

public class FloristeriaControlador {

	private final TicketRepo ticketRepo = new TicketRepo();
	
	public Floristeria createFloristeria(String nomFloristeria) throws Exception {
		return new Floristeria(nomFloristeria);
	}
	
	public void addArbol(Floristeria floristeria, String name, double height, double price) throws Exception {
		floristeria.addTree(name, height, price);
	}
	
	public void addFlor(Floristeria floristeria, String name, String color, double price) throws Exception {
		floristeria.addFlower(name, color, price);
	}
	
	public void addDecoracion(Floristeria floristeria, String name, String type, double price) throws Exception {
		floristeria.addDecoration(name, type, price);
	}
	
	public void removerProducto(Floristeria floristeria, int id) throws Exception {
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
	
	public void createTicket(Floristeria floristeria, HashSet<Integer> idsTicket) throws Exception {
		
		List<Producto> productosTicket  = floristeria.getAllProducts().stream()
				.filter(prod -> idsTicket.stream()
						.anyMatch(id -> prod.getId() == id))
				.collect(Collectors.toList());
		
		Ticket ticket = new Ticket(productosTicket);
		ticketRepo.addTicket(ticket);
		ticket.printTicket();

		for (Integer id : idsTicket) {
			try {
				floristeria.removeProduct(id);
			} catch (Exception e) {
				System.err.println("No se pudo retirar el producto");
				System.err.println(e.getMessage());
			}
		}
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
}
