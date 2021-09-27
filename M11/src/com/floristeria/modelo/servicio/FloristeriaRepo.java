package com.floristeria.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.modelo.dominio.Producto;

public class FloristeriaRepo {
	
		private final List<Producto> productList = new ArrayList<>();

		public FloristeriaRepo(){
		}
		
		public List<Producto> getAllProducts(){
			return productList;
		}
				
		public void addProduct(Producto producto) throws Exception {
			if(producto == null) throw new Exception();
			productList.add(producto);
		}

		public void removeProduct(int id) throws Exception {
			if (productList.stream().anyMatch(p -> p.getId() == id)) {
				productList.removeIf(p -> p.getId() == id);
			} else {
				throw new Exception("No se ha encontrado ningún producto con este id.");
			}
			
		}
		
}
