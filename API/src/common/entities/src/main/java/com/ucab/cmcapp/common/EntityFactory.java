package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    //TipoUsuario
    public static TipoUsuario createTipoUsuario() {
        return new TipoUsuario();
    }

    public static TipoUsuario createTipoUsuario(long id) {
        return new TipoUsuario(id);
    }


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
