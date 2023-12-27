package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory {
    private DaoFactory() {
    }

    public static AdministradorDao createAdministradorDao(DBHandler handler) {
        try{
            return new AdministradorDao(handler);
        }catch(NoClassDefFoundError e){
            return null;
        }
        catch(ExceptionInInitializerError e){
            return null;
        }
        catch(Exception e){
            return null;
        }

    }

    public static UsuarioDao createUsuarioDao(DBHandler handler) {
        try{
            return new UsuarioDao(handler);
        }catch(Exception e){
            return null;
        }

    }

    public static CoordenadaDao createCoordenadaDao(DBHandler handler) {
        try{
            return new CoordenadaDao(handler);
        }catch(Exception e){
            return null;
        }
    }

    public static Zona_SeguraDao createZona_SeguraDao(DBHandler handler) {
        try{
            return new Zona_SeguraDao(handler);
        }catch(Exception e){
            return null;
        }
    }

    public static Historico_UsuarioDao createHistorico_UsuarioDao(DBHandler handler) {
        try{
            return new Historico_UsuarioDao(handler);
        }catch(Exception e){
            return null;
        }
    }

    public static Usuario_VictimaDao createUsuario_VictimaDao(DBHandler handler) {
        try{
            return new Usuario_VictimaDao(handler);
        }catch(Exception e){
            return null;
        }
    }

    public static Usuario_AtacanteDao createUsuario_AtacanteDao(DBHandler handler) {
        try{
            return new Usuario_AtacanteDao(handler);
        }catch(Exception e){
            return null;
        }
    }

    public static Relacion_VADao createRelacion_VADao(DBHandler handler) {
        try{
            return new Relacion_VADao(handler);
        }catch(Exception e){
            return null;
        }
    }

}
