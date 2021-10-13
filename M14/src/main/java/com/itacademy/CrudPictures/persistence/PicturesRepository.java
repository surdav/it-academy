package com.itacademy.CrudPictures.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.CrudPictures.domain.Picture;

@Repository
public interface PicturesRepository extends JpaRepository<Picture, Integer>{

}
