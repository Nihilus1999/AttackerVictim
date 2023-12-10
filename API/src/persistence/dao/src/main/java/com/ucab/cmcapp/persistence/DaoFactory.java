package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    public static AdministradorDao createAdministradorDao(DBHandler handler) {
        return new AdministradorDao(handler);
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

    public static Usuario_VictimaDao createUsuario_VictimaDao(DBHandler handler) {
        return new Usuario_VictimaDao(handler);
    }

    public static Usuario_AtacanteDao createUsuario_AtacanteDao(DBHandler handler) {
        return new Usuario_AtacanteDao(handler);
    }

    public static Relacion_VADao createRelacion_VADao(DBHandler handler) {
        return new Relacion_VADao(handler);
    }

}
