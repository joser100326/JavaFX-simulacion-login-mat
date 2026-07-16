package com.joserosales.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class BienvenidaView extends VBox {

    private static BienvenidaView instanciaBienvenidaView;
    private Label lblMensajeBienvenida;
    private Button btnCerrar;
    private HBox barraSuperior;

    public BienvenidaView(String nombreUsuario) {
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(15);
        this.setPadding(new Insets(15));

        // Borde y fondo redondeado para que se adapte al Stage transparente
        this.setBorder(new Border(new BorderStroke(
                Color.DARKBLUE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(20),
                new BorderWidths(2)
        )));
        this.setBackground(new Background(new BackgroundFill(
                Paint.valueOf("#D4F1F4"), // Color de fondo personalizado
                new CornerRadii(20),
                Insets.EMPTY
        )));

        // Barra superior alineada a la derecha para colocar el botón de cierre
        barraSuperior = new HBox();
        barraSuperior.setAlignment(Pos.TOP_RIGHT);

        btnCerrar = new Button("X");
        barraSuperior.getChildren().add(btnCerrar);

        // Etiqueta del mensaje personalizado
        lblMensajeBienvenida = new Label("Bienvenido, " + nombreUsuario);
        lblMensajeBienvenida.setFont(new Font("Arial", 16));
        lblMensajeBienvenida.setPadding(new Insets(10, 0, 20, 0));

        this.getChildren().addAll(barraSuperior, lblMensajeBienvenida);
    }

    public Button getBtnCerrar() {
        return btnCerrar;
    }

    public static BienvenidaView getInstanciaBienvenidaView(String nombreUsuario) {
        if (instanciaBienvenidaView == null) {
            instanciaBienvenidaView = new BienvenidaView(nombreUsuario);
        }
        return instanciaBienvenidaView;
    }

    public static void setInstanciaBienvenidaView(BienvenidaView instanciaBienvenidaView) {
        BienvenidaView.instanciaBienvenidaView = instanciaBienvenidaView;
    }
}
