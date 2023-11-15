package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory {

    public static Usuario createUsuario() {
        return new Usuario();
    }

    public static Usuario createUsuario(long id) {
        return new Usuario(id);
    }

    public static TipoUsuario createTipoUsuario() {
        return new TipoUsuario();
    }

    public static TipoUsuario createTipoUsuario(long id) {
        return new TipoUsuario(id);
    }
}
