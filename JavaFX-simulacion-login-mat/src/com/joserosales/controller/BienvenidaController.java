package com.joserosales.controller;

import com.joserosales.view.BienvenidaView;
import javafx.stage.Stage;

public class BienvenidaController {

    private final BienvenidaView BIENVENIDA_VIEW;
    private double ejeX = 0;
    private double ejeY = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioSecundario();

    public BienvenidaController(BienvenidaView bienvenidaView) {
        this.BIENVENIDA_VIEW = bienvenidaView;
        construirAcciones();
    }

    private void construirAcciones() {
        // Cierra la ventana actual de bienvenida al hacer clic en la "X"
        this.BIENVENIDA_VIEW.getBtnCerrar().setOnMouseClicked(
                (evento) -> {
                    if (escenario != null) {
                        escenario.close();
                    }
                }
        );

        // Guarda la posición inicial del puntero al presionar el panel
        this.BIENVENIDA_VIEW.setOnMousePressed(
                (evento) -> {
                    ejeX = evento.getSceneX();
                    ejeY = evento.getSceneY();
                }
        );

        // Desplaza la ventana conforme el usuario arrastra el ratón
        this.BIENVENIDA_VIEW.setOnMouseDragged(
                (evento) -> {
                    if (escenario != null) {
                        double desplazamientoX = evento.getScreenX();
                        double desplazamientoY = evento.getScreenY();

                        escenario.setX(desplazamientoX - ejeX);
                        escenario.setY(desplazamientoY - ejeY);
                    }
                }
        );
    }
}
