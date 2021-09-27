package com.floristeria.modelo.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ticket {

	private final int id;
	private static int next_id = 0;
	private final LocalDateTime creationDate;
	private final double totalValue;
	private final List<Producto> productList;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("'FECHA:' dd/MM/yyyy	'HORA:' HH:mm");

	public Ticket(List<Producto> compra) throws Exception {
		if (compra.isEmpty())
			throw new Exception("Debe introducir al menos un producto para crear un ticket.");
		id = next_id++;
		productList = compra;
		totalValue = compra.stream().mapToDouble((Producto::getPrice)).sum();
		creationDate = LocalDateTime.now();
	}

	public double getTotalValue() {
		return totalValue;
	}

	@Override
	public String toString() {
		return "ID_TICKET: " + id + "	" + creationDate.format(format) + "	VALOR TOTAL: " + totalValue;
	}

	public void printTicket() {

		System.out.println(this);
		productList.forEach(System.out::println);
	}

}
