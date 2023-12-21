package com.ucab.cmcapp.logic.dtos.dtos;


public class AdministradorDto extends BaseDto {


    private String _alias;
    private String _correo;
    private String _clave;


    public AdministradorDto() {

    }

    public AdministradorDto(long id) {
        super(id);
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }


    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }


    public String get_clave() {
        return _clave;
    }

    public void set_clave(String _clave) {
        this._clave = _clave;
    }

}
