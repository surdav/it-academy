package com.itacademy.CrudPictures.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.CrudPictures.domain.Shop;
import com.itacademy.CrudPictures.service.ShopServices;

@RestController
@RequestMapping("")
public class ShopsController {
	/*
	 * Controller CRUD shops
	 */
	@Autowired
	ShopServices shopServices;

	//create new shop
	@PostMapping("/shops")
	@ResponseStatus(HttpStatus.CREATED)  // 201
	public Shop addShop(@Valid @RequestBody Shop shop) {
		shopServices.add(shop);
		return shop;
	}
	
	//get a shop List
	@GetMapping("/shops")
	public List<Shop> allShops(){
		return shopServices.getAll();
	}
	
	//get shop by ID
	@GetMapping("/shops/{id}")
	public Shop getAllPictures(@PathVariable("id") int id){
		return shopServices.getById(id);
	}
	
	//update shop
	@PutMapping("/shops/{id}")
	public Shop updateShop(@PathVariable("id") int idShop, @Valid @RequestBody Shop shop) {
		return shopServices.update(idShop,shop);
	}
	
	//delete shop
	@DeleteMapping("/shops/{id}")
	public String deleteShop(@PathVariable("id") int idShop) {
		shopServices.deleteShop(idShop);
		return "Tienda borrada correctamente";
	}
	
}
