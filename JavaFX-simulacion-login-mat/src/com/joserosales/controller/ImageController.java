package com.joserosales.controller;

import javafx.scene.image.Image;

public class ImageController {

    private final String RUTA_IMAGENES = "/com/joserosales/resources/";

    //Metodo que usa el patron Factory, para crear diferentes imagenes y retornaras
    //nombreImagen El nombre de la imagen a crear
    // La imagen a mostrar
    public Image getImageLogin(String nombreImagen) {
        Image imagenAMostrar;

        switch (nombreImagen) {
            case "logo":
                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");
                break;
            default:
                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");
        }
        return imagenAMostrar;
    }
}
