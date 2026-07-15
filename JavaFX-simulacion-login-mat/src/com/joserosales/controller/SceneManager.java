package com.joserosales.controller;

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
    private SceneManager(){    
    }
    

    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto){

        try{
            escenaPrincipal = new Scene(panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();

        }catch (NullPointerException objetoNulo ){
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: cambiar Escena Principal ");
            objetoNulo . printStackTrace();
            }catch (Exception errorPadre){
                JOptionPane.showMessageDialog(null, "Error padre: cambiar Escena Principal");
                errorPadre. printStackTrace();

        }

    }

    public void ventanaLogin(){
      try{
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
             LoginView login = LoginView.getInstanciaLoginView();
             cambiarEscenaPrincipal(login,450,325);
             this.escenaPrincipal.setFill(Color.TRANSPARENT); //El fondo de la escena es transparente
             new LoginController( login );
             
        }catch (NullPointerException objetoNulo ){
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: ventana Login ");
            objetoNulo . printStackTrace(); //imprime todo el camino hacia el error
            }catch (Exception errorPadre){
                JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
                errorPadre. printStackTrace();
        }   

    }
        public void ventanaBienvenida(){
      try{
            escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
             this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
             BienvenidaView bienvenida = new BienvenidaView();
             escenaPrincipal = new Scene( )
             
             
        }catch (NullPointerException objetoNulo ){
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: ventana Login ");
            objetoNulo . printStackTrace(); //imprime todo el camino hacia el error
            }catch (Exception errorPadre){
                JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
                errorPadre. printStackTrace();
        }   

    }
    

 
    public static SceneManager getInstanciaSceneManager() {
        if( instanciaSceneManager == null )
            instanciaSceneManager = new SceneManager();
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