package com.joserosales.controller;

import com.joserosales.model.Rol;
import com.joserosales.model.Usuario;
import java.util.ArrayList;
import javax.swing.text.PasswordView;

public class AuthSistema {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList();

    public AuthSistema() {
        Usuario usuarioAdmin = new Usuario("admin",
                "123", "admin", Rol.ADMIN);
        Usuario usuarioUser = new Usuario("user",
                "123", "user", Rol.USER);
        Usuario usuarioYo = new Usuario("Jose",
                "123", "Jose Rosales Hernandez", Rol.USER);

        listaUsuarios.add(usuarioAdmin);
        listaUsuarios.add(usuarioUser);
        listaUsuarios.add(usuarioYo);
    }

    public Usuario login(String nombreUsuario, String clave) {
        for (Usuario usuarioBuscado : listaUsuarios) {
            if (usuarioBuscado.getNombreUsuario().equals(nombreUsuario)
                    && usuarioBuscado.getPassword().equals(clave)) {
                return usuarioBuscado;
            }
        }
        return null;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        AuthSistema.listaUsuarios = listaUsuarios;
    }

}
