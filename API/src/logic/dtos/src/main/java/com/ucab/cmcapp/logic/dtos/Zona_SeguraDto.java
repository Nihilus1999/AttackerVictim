package com.ucab.cmcapp.logic.dtos;


import java.util.Date;

public class Zona_SeguraDto extends BaseDto {

    private String _nombre;

    private UsuarioDto _usuario;

    public Zona_SeguraDto() {

    }

    public Zona_SeguraDto(long id) {
        super(id);
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
