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

    //Historico_Usuario

    public static Historico_Usuario createHistorico_Usuario() {
        return new Historico_Usuario();
    }
    public static Historico_Usuario createHistorico_Usuario(long id) {
        return new Historico_Usuario(id);
    }


    //Zona Segura
    public static Zona_Segura createZona_Segura() {
        return new Zona_Segura();
    }
    public static Zona_Segura createZona_Segura(long id) {
        return new Zona_Segura(id);
    }


    //Coordenada
    public static Coordenada createCoordenada() {
        return new Coordenada();
    }
    public static Coordenada createCoordenada(long id) {
        return new Coordenada(id);
    }

}
