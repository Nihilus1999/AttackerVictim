package com.ucab.cmcapp.logic.dtos.dtos;


import java.util.Date;

public class Historico_UsuarioDto extends BaseDto {

    private Date _fecha;
    private Boolean _estadoConexion;
    private double _latitud;
    private double _longitud;

    private UsuarioDto _usuario;


    public Historico_UsuarioDto() {

    }

    public Historico_UsuarioDto(long id) {
        super(id);
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Boolean get_estadoConexion() {
        return _estadoConexion;
    }

    public void set_estadoConexion(Boolean _estadoConexion) {
        this._estadoConexion = _estadoConexion;
    }

    public double get_latitud() {
        return _latitud;
    }

    public void set_latitud(double _latitud) {
        this._latitud = _latitud;
    }

    public double get_longitud() {
        return _longitud;
    }

    public void set_longitud(double _longitud) {
        this._longitud = _longitud;
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
