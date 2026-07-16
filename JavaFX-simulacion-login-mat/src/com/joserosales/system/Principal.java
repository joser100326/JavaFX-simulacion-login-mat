package com.joserosales.system;

import com.joserosales.controller.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioRaiz) {
        SceneManager.getInstanciaSceneManager().setEscenarioPrincipal(escenarioRaiz);
        SceneManager.getInstanciaSceneManager().ventanaLogin();

    }

}
