package com.itacademy.CrudPictures.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pictures")
@JsonIgnoreProperties("shopDTO")
public class Picture {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="picture_id")
	private int id;
	
	@NotBlank
	@Column(name="picture_author")
	private String author;
	
	@NotBlank
	@Column(name="picture_name")
	private String name;

	@NotNull
	@Column(name="picture_price")
	private double price;
		
	@CreationTimestamp
	@Column(name="picture_registrationdate",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date registrationDate ;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shopDTO; 

		public Picture() {
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

		public Shop getShopDTO() {
		return shopDTO;
	}

	public void setShopDTO(Shop shopDTO) {
		this.shopDTO = shopDTO;
	}

}
