package com.joserosales.controller;

import com.joserosales.view.LoginView;

public class LoginController {
    private final LoginView LOGIN_VIEW;
    
    
    public LoginController(LoginView loginView){
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }
    
     public void construirAcciones(){
         this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                 (evento)->{
                     System.exit(0);
                 }
         );
     }
}






