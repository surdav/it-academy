package com.itacademy.CrudPictures.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.CrudPictures.domain.Shop;

@Repository
public interface ShopsRepository extends JpaRepository<Shop, Integer>{

}
