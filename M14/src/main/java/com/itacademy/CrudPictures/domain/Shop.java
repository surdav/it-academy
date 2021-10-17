package com.itacademy.CrudPictures.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shops")
@JsonIgnoreProperties("pictures")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shop_id")
	@NotNull
	private int id;
	
	@NotBlank
	@Column(name="shop_name")
	private String name;
	
	@NotNull
	@Column(name="shop_capacity")
	private int capacity=10;
	
	@CreationTimestamp
	@Column(name="shop_creationdata",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date creationdate;

	@Transient //parameter without column
	private int population=0;
	
	//mappedBy does the reference to the shop variable name defined in Picture class by @ManyToOne
	//not to any element inside MySQL columns
	@OneToMany(mappedBy = "shopDTO") 
	private Set<Picture> pictures;

	public Shop() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	
	public int getPopulation() {
		if(pictures==null) {
			return population;
		}
		return pictures.size();
	}
	
	public void setPopulation(int population) {
		this.population=population;

	}
}