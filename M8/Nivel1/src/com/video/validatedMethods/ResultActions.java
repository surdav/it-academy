package com.video.validatedMethods;

import com.video.application.CampsBuits;
import com.video.application.VideoUserController;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.view.VideoUserView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class ResultActions {

    public static int enterInteger() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.err.println("La entrada tiene que ser numérica");
            }
        }
    }

    public static String insertUserName() {
        System.out.println("Introduzca tu nombre");
        return receiveNotEmptyEntry();
    }

    public static String insertUserSurname() {
        System.out.println("Introduzca tu apellido");
        return receiveNotEmptyEntry();
    }

    public static String insertUserPassword() {
        System.out.println("Introduzca tu contraseña");
        return receiveNotEmptyEntry();
    }

    public static String insertTitle() {
        System.out.println("Introduzca el título del vídeo");
        return receiveNotEmptyEntry();
    }

    public static String insertTag() throws CampsBuits {
        return receiveNotEmptyEntry();
    }

    private static String receiveNotEmptyEntry() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                String entradaNomTag = sc.nextLine();
                if (entradaNomTag.matches("\\s*")) {
                    throw new CampsBuits("La entrada no puede ser vacía!");
                } else return entradaNomTag;

            } catch (CampsBuits e) {
                System.err.println("La entrada no puede ser vacía!");
            }
        }
    }


    public static Tag createTags() throws InputMismatchException, CampsBuits {

        int cantidadTags;
        System.out.println("Cuántos tags quieres crear?");

        cantidadTags = enterInteger();
        if (cantidadTags <= 0) exit(0);

        List<String> tagsList = new ArrayList<>();

        for (int i = 1; i <= cantidadTags; i++) {
            System.out.println("Introduzca el tag nº " + i);

            String entradaNomTag = insertTag();

            tagsList.add(entradaNomTag);
        }

        return new Tag(tagsList);
    }

    private static String insertUrl() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Introduzca URL del vídeo:");
                String url = sc.nextLine();
                if (!url.matches("((http|https)://)?(www\\.)?.+\\.[a-zA-Z]{2,3}")) {
                    throw new Exception("El formato de URL no correcto!");
                } else return url;

            } catch (Exception e) {
                System.err.println("El formato de URL no correcto!");
            }
        }
    }

    public static Video createNewVideo() {
        Video video = new Video();

        video.setUrl(insertUrl());
        video.setTitle(insertTitle());
        video.setTags(createTags());

        return video;
    }

    public static User createNewUser() {
        User user = new User();

        user.setName(insertUserName());
        user.setSurname(insertUserSurname());
        user.setPassword(insertUserPassword());

        return user;
    }

    public static void videoAppFlowController() {
        int opcion;
        while (true) {
            System.out.println("----------- MENU DE NAVEGACIÓN PRINCIPAL -----------");
            System.out.println("Pulsa una de las siguientes opciones:");
            System.out.println("Pulsa 1 para Crear nuevo usuario y vídeo");
            System.out.println("Pulsa 2 para Salir");

            opcion = enterInteger();

            if (opcion == 2) break;
            else if (opcion == 1) {

                // creamos el usuario
                User userModel = createNewUser();

                // creamos el video
                Video videoModel = createNewVideo();
                // añadimos el vídeo creado a la lista de los vídeos del usuario
                userModel.setMyVideos(videoModel);

                // creamos vista: para mostrar los detalles del video en la consola
                VideoUserView view = new VideoUserView();

                // creamos el controlador
                VideoUserController controller = new VideoUserController(userModel, videoModel, view);

                // mostramos datos
                controller.updateView();

                while (true) {
                    System.out.println("----------- SUBMENU DE NAVEGACIÓN -----------");
                    System.out.println("Elige una de las siguientes opciones:");
                    System.out.println("Pulsa 2 para añadir nuevo vídeo");
                    System.out.println("Pulsa 3 para Listar todos los vídeos");
                    System.out.println("Pulsa 4 para ir al Menu Principal");
                    System.out.println("Pulsa 5 para TERMINAR EL PROGRAMA");

                    opcion = enterInteger();

                    if (opcion == 4) break;
                    if (opcion == 5) exit(0);

                    else if (opcion == 2) {
                        // creamos nuevo video
                        Video newVideoModel = createNewVideo();

                        // añadimos el vídeo creado a la lista de los vídeos del usuario
                        userModel.setMyVideos(newVideoModel);

                        // mostramos nuevo vídeo
                        controller.showNewVideo(newVideoModel);
                    }

                    else if (opcion == 3) {
                        controller.showUserVideos();
                    } else {
                        try {
                            throw new Exception("Elige entre 2, 3, 4 y 5!");
                        } catch (Exception e) {
                            System.err.println("Elige entre 2, 3, 4 y 5!");
                        }
                    }
                }
            } else {
                try {
                    throw new Exception("Elige entre 1 y 2!");
                } catch (Exception e) {
                    System.err.println("Elige entre 1 y 2!");
                }
            }
        }
    }
}
