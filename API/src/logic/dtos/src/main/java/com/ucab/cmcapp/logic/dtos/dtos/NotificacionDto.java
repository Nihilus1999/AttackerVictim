package com.ucab.cmcapp.logic.dtos.dtos;


import java.util.Date;

public class NotificacionDto extends BaseDto {

    private Date _fecha;
    private String _tipo;
    private String _descripcion;
    private UsuarioDto _usuario;


    public NotificacionDto() {

    }

    public NotificacionDto(long id) {
        super(id);
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
