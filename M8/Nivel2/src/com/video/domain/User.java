package com.video.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String password;
    private final List<Video> myVideos = new ArrayList<>();

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String registerDate = formatter.format(date);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMyVideos() {
        String cadena = "";
        // return myVideos.toString();
        for (Video video : myVideos) {
            cadena += video.toString() + "\n";
        }
        return cadena;
    }

    public void setMyVideos(Video video) {
        this.myVideos.add(video);
    }

    public String getRegisterDate() {
        return registerDate;
    }
}