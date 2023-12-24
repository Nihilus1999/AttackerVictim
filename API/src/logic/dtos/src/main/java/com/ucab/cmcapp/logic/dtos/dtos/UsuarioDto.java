package com.ucab.cmcapp.logic.dtos.dtos;


import com.ucab.cmcapp.logic.dtos.dtos.BaseDto;

public class UsuarioDto extends BaseDto {

    private String _nombre;
    private String _apellido;
    private String _alias;
    private String _cedula;
    private String _correo;
    private String _direccion_mac;

    private String _clave;
    private Boolean _activate;


    public UsuarioDto() {

    }

    public UsuarioDto(long id) {
        super(id);
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_cedula() {
        return _cedula;
    }

    public void set_cedula(String _cedula) {
        this._cedula = _cedula;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    public String get_direccion_mac() {
        return _direccion_mac;
    }

    public void set_direccion_mac(String _direccion_mac) {
        this._direccion_mac = _direccion_mac;
    }

    public String get_clave() {
        return _clave;
    }

    public void set_clave(String _clave) {
        this._clave = _clave;
    }

    public Boolean get_activate() {
        return _activate;
    }

    public void set_activate(Boolean _activate) {
        this._activate = _activate;
    }
}
