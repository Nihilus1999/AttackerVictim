package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    //ADMINISTRADOR

    public static Administrador createAdministrador() {
        return new Administrador();
    }
    public static Administrador createAdministrador(long id) {
        return new Administrador(id);
    }


    //USUARIO
    public static Usuario createUsuario() {
        return new Usuario();
    }
    public static Usuario createUsuario(long id) {
        return new Usuario(id);
    }


    //HISTORICO_USUARIO

    public static Historico_Usuario createHistorico_Usuario() {
        return new Historico_Usuario();
    }
    public static Historico_Usuario createHistorico_Usuario(long id) {
        return new Historico_Usuario(id);
    }


    //USUARIO_VICTIMA

    public static Usuario_Victima createUsuario_Victima() {
        return new Usuario_Victima();
    }
    public static Usuario_Victima createUsuario_Victima(long id) {
        return new Usuario_Victima(id);
    }


    //USUARIO_ATACANTE

    public static Usuario_Atacante createUsuario_Atacante() {
        return new Usuario_Atacante();
    }
    public static Usuario_Atacante createUsuario_Atacante(long id) {
        return new Usuario_Atacante(id);
    }

    //RELACION_VICTIMA-ATACANTE

    public static Relacion_VA createRelacion_VA() {
        return new Relacion_VA();
    }
    public static Relacion_VA createRelacion_VA(long id) {
        return new Relacion_VA(id);
    }

    //ZONA_SEGURA
    public static Zona_Segura createZona_Segura() {
        return new Zona_Segura();
    }
    public static Zona_Segura createZona_Segura(long id) {
        return new Zona_Segura(id);
    }


    //COORDENADAS
    public static Coordenada createCoordenada() {
        return new Coordenada();
    }
    public static Coordenada createCoordenada(long id) {
        return new Coordenada(id);
    }


    //NOTIFICACION
    public static Notificacion createNotificacion() {
        return new Notificacion();
    }
    public static Notificacion createNotificacion(long id) {
        return new Notificacion(id);
    }

}
