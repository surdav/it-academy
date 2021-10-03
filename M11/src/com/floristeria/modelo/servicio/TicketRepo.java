package com.floristeria.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.controlador.NoContentException;
import com.floristeria.modelo.dominio.Ticket;

public class TicketRepo {
	
		private final List<Ticket> ticketList = new ArrayList<>();

		public TicketRepo(){
		}
		
		public List<Ticket> getAllTickets(){
			return ticketList;
		}
				
		public void addTicket(Ticket ticket) throws NoContentException {
			if(ticket == null) throw new NoContentException();
			ticketList.add(ticket);
		}		
}
