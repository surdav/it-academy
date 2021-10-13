package com.itacademy.CrudPictures.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.itacademy.CrudPictures.domain.Picture;
import com.itacademy.CrudPictures.domain.Shop;

@Controller
public class WebController {

	/*
	 * Controller View
	 * 
	 * Done with RestTemplate to simulate and independent APP that request info to the Rest API.
	 * View side programmed with thymeleaf and html.
	 * 
	 */
	
	String host = "http://localhost:8080";

	// redirect from Root
	@RequestMapping("/")
	public String redirectFromRoot(Model model) {
		return "redirect:/index";
	}

	// index access
	@RequestMapping("/index")
	public String goIndex(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Shop[]> shops = restTemplate.getForEntity(host + "/shops", Shop[].class);
		model.addAttribute("shops", shops.getBody());
		model.addAttribute("Shop", new Shop());
		return "index";
	}

	// create new shop
	@PostMapping("/shopTable")
	public String addShop(Model model, Shop shop) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(host + "/shops", shop, Shop.class);
		return "redirect:/index";
	}

	// get shop and show on table
	@GetMapping("/shopTable/{id}")
	public String openShop(@PathVariable("id") int id, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Picture[]> pictures = restTemplate
				.getForEntity(host + "/shops/" + id + "/pictures", Picture[].class);
		model.addAttribute("pictures", pictures.getBody());
		model.addAttribute("Picture", new Picture());
		ResponseEntity<Shop> shop = restTemplate.getForEntity(host + "/shops/" + id, Shop.class);
		model.addAttribute("shop", shop.getBody());
		return "shopTable";
	}

	// update one shop
	@PostMapping("/shopTable/{id}/updateShop/")
	public String updateShop(@PathVariable("id") int idShop, Shop shop, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(host + "/shops/" + idShop, shop);
		return "redirect:/index";
	}

	// delete one shop
	@GetMapping("/shopTable/{id}/deleteshop/")
	public String deleteshop(@PathVariable("id") int idShop, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(host + "/shops/" + idShop);
		return "redirect:/index";
	}


	// Post one picture
	@PostMapping("/shopTable/{id}/addpicture/")
	public String addPicture(@PathVariable("id") int idShop, Model model, Picture picture) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(host + "/shops/" + idShop + "/pictures/", picture, Picture.class);
		return "redirect:/shopTable/" + idShop;
	}

	// delete one picture
	@GetMapping("/shopTable/{idShop}/delete/{idPicture}")
	public String deletePictures(@PathVariable("idShop") int idShop, @PathVariable("idPicture") int idPictures,
			Model model) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(host + "/shops/" + idShop + "/pictures/" + idPictures);
		return "redirect:/shopTable/" + idShop;
	}
	
	// delete all pictures from shop
	@GetMapping("/shopTable/{id}/delete/")
	public String deletePictures(@PathVariable("id") int idShop, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(host + "/shops/" + idShop + "/pictures");
		return "redirect:/shopTable/" + idShop;
	}

	// update one picture
	@PostMapping("/shopTable/{idShop}/updatePicture/{idPicture}")
	public String updateOnePicture(@PathVariable("idShop") int idShop, @PathVariable("idPicture") int idPictures,
			Model model, Picture picture) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(host + "/shops/" + idShop + "/pictures/" + idPictures, picture);
		return "redirect:/shopTable/" + idShop;
	}
}
