package com.itacademy.CrudPictures.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.CrudPictures.domain.Shop;
import com.itacademy.CrudPictures.persistence.ShopsRepository;

@Service
public class ShopServices {

	@Autowired
	ShopsRepository shopReposity;
	
	@Autowired
	PicturesService picturesService;

	//add new shop to repository
	public void add(@Valid Shop shop) {
		shopReposity.save(shop);		
	}

	//return a Shop List from repository
	public List<Shop> getAll() {
		return shopReposity.findAll();
	}
	
	//find and return one Shop by Id from respository
	public Shop getById(int id) {
		return shopReposity.findById(id).get();
	}

	//update shop on repository
	public Shop update(int idShop, @Valid Shop shop) {
		Shop dbShop= getById(idShop);
		dbShop.setName(shop.getName());
		dbShop.setCapacity(shop.getCapacity());
		shopReposity.save(dbShop);
		return getById(idShop);
	}

	//delete shop on repository
	public void deleteShop(int idShop) {
		picturesService.deleteAllPictures(idShop);
		shopReposity.deleteById(idShop);
	}
	
}
