package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    public static UsuarioDao createUsuarioDao(DBHandler handler) {
        return new UsuarioDao(handler);
    }

    public static CoordenadaDao createCoordenadaDao(DBHandler handler) {
        return new CoordenadaDao(handler);
    }

    public static Zona_SeguraDao createZona_SeguraDao(DBHandler handler) {
        return new Zona_SeguraDao(handler);
    }

    public static Historico_UsuarioDao createHistorico_UsuarioDao(DBHandler handler) {
        return new Historico_UsuarioDao(handler);
    }

}
