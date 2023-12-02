package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    //TipoUsuario


    //Usuario
    public static Usuario createUsuario() {
        return new Usuario();
    }
    public static Usuario createUsuario(long id) {
        return new Usuario(id);
    }


    //Coordenada
    public static Coordenada createCoordenada() {
        return new Coordenada();
    }

    public static Coordenada createCoordenada(long id) {
        return new Coordenada(id);
    }

}
