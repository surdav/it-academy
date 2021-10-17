package com.itacademy.CrudPictures.service;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.CrudPictures.domain.Picture;
import com.itacademy.CrudPictures.domain.Shop;
import com.itacademy.CrudPictures.exceptions.FullShopException;
import com.itacademy.CrudPictures.persistence.PicturesRepository;

@Service
public class PicturesService {

	@Autowired
	PicturesRepository pictureRepository;

	@Autowired
	ShopServices shopServices;
	
	//add picture to repository
	public Picture add(@Valid Picture picture, int id){
		
		Shop shop = shopServices.getById(id);
		
		//check shop capacity
		if(shop.getCapacity() <= shop.getPopulation()) {
			throw new FullShopException("La joyería ya está llena!");			
		}
		picture.setShopDTO(shop);
		pictureRepository.save(picture);
		return picture;
	}

	//get a Set of pictures from repository
	public Set<Picture> getAll(int idShop) {
		return shopServices.getById(idShop).getPictures();
	}

	//delete ALL pictures from repository
	public void deleteAllPictures(int idShop) {
		pictureRepository.deleteAll(getAll(idShop));;
	}

	//delete one picture on repository
	public void deleteById(int idPicture) {
		pictureRepository.deleteById(idPicture);
	}

	//return one picture from repository
	public Picture getById(int idPicture) {
		return pictureRepository.findById(idPicture).get();
	}

	//update one picture on repository
	public Picture updatePicture(int idPicture, Picture picture) {
		Picture dbPicture = getById(idPicture);
		dbPicture.setAuthor(picture.getAuthor());
		dbPicture.setName(picture.getName());
		dbPicture.setPrice(picture.getPrice());
		pictureRepository.save(dbPicture);
		return getById(idPicture);
	}

}
