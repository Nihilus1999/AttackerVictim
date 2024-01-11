package com.ucab.cmcapp.logic.dtos.utilities;

public class CredencialesDto {
    private String _alias;

    private String _clave;

    public CredencialesDto() {

    }

    public CredencialesDto(String _alias, String _clave) {
        this._alias = _alias;
        this._clave = _clave;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_clave() {
        return _clave;
    }

    public void set_clave(String _clave) {
        this._clave = _clave;
    }
}
