package com.joserosales.controller;

import com.joserosales.model.Usuario;
import com.joserosales.view.BienvenidaView;
import com.joserosales.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Stage escenarioSecundario;
    private Scene escenaPrincipal;

    private SceneManager() {
    }

    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {

        try {
            escenaPrincipal = new Scene(panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: cambiar Escena Principal ");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: cambiar Escena Principal");
            errorPadre.printStackTrace();

        }

    }

    public void ventanaLogin() {
        try {
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(login, 450, 325);
            this.escenaPrincipal.setFill(Color.TRANSPARENT); //El fondo de la escena es transparente
            new LoginController(login);

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: ventana Login ");
            objetoNulo.printStackTrace(); //imprime todo el camino hacia el error
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
            errorPadre.printStackTrace();
        }

    }

    public void ventanaBienvenida(Usuario usuario) {
        try {
            // Cerramos la ventana de Login
            if (this.escenarioPrincipal != null) {
                this.escenarioPrincipal.close();
            }

            escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);

            // Instanciamos la vista pasando el nombre del usuario logueado
            BienvenidaView bienvenida = new BienvenidaView(usuario.getNombreCompleto());

            escenaPrincipal = new Scene(bienvenida, 320, 150);
            
            escenaPrincipal.setFill(Color.TRANSPARENT);

            this.escenarioSecundario.setScene(escenaPrincipal);
            this.escenarioSecundario.sizeToScene();

            // Activamos el controlador de movimiento y cierre
            new BienvenidaController(bienvenida);

            this.escenarioSecundario.show();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: ventana Bienvenida");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Bienvenida");
            errorPadre.printStackTrace();
        }
    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }

    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {
        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Stage getEscenarioSecundario() {
        return escenarioSecundario;
    }

    public void setEscenarioSecundario(Stage escenarioSecundario) {
        this.escenarioSecundario = escenarioSecundario;
    }

    public Scene getEscenaPrincipal() {

        return escenaPrincipal;

    }

    public void setEscenaPrincipal(Scene escenaPrincipal) {

        this.escenaPrincipal = escenaPrincipal;

    }

}
