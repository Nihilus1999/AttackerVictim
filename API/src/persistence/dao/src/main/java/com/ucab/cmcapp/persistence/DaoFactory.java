package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    public static UsuarioDao createUsuarioDao(DBHandler handler) {
        return new UsuarioDao(handler);
    }

}
