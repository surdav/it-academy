package com.floristeria.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.controlador.NoContentException;
import com.floristeria.modelo.dominio.Producto;

public class FloristeriaRepo {
	
		private final List<Producto> productList = new ArrayList<>();

		public FloristeriaRepo(){
		}
		
		public List<Producto> getAllProducts(){
			return productList;
		}
				
		public void addProduct(Producto producto) throws NoContentException {
			if(producto == null) throw new NoContentException();
			productList.add(producto);
		}

		public void removeProduct(int id) throws NoContentException {
			if (productList.stream().anyMatch(p -> p.getId() == id)) {
				productList.removeIf(p -> p.getId() == id);
			} else {
				throw new NoContentException("No se ha encontrado ningún producto con este id.");
			}
			
		}
		
}
