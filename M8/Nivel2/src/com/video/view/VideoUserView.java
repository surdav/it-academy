package com.video.view;

import com.video.domain.Tag;

public class VideoUserView {

    public void showUser(String userName, String userSurname, String userPassword, String userRegisterDate, String myVideos) {
        System.out.println();
        System.out.println("Los datos del creador de los vídeos son los siguientes: ");
        System.out.println("Nombre: " + userName);
        System.out.println("Apellido: " + userSurname);
        System.out.println("Contraseña: " + userPassword);
        System.out.println("La fecha del registro: " + userRegisterDate);
        System.out.println("Todos los vídeos del autor hasta ahora: \n" + myVideos);
        System.out.println();
    }

    public void showVideo(String url, String title, Tag tags) {
        System.out.println("Ahora se ha creado el siguiente vídeo: ");
        System.out.println("URL: " + url);
        System.out.println("Título: " + title);
        System.out.println("Tags: " + tags);
        System.out.println();
    }

    public void listUserVideos(String myVideos) {
        System.out.println();
        System.out.println("Todos los vídeos del autor hasta ahora: \n" + myVideos);
        System.out.println();
    }

    public void showNewAddedVideo(String userName, String userSurname, String myVideos, String url, String title, Tag tags) {
        System.out.println();
        System.out.println(userName + " " + userSurname + " ha añadido el siguiente vídeo:");
        System.out.println("URL: " + url);
        System.out.println("Título: " + title);
        System.out.println("Tags: " + tags);
        System.out.println();
        System.out.println("Ahora tiene en su lista los siguientes vídeos: \n" + myVideos);
        System.out.println();
    }


}
