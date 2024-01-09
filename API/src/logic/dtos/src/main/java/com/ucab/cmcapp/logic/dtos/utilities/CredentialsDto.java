package com.ucab.cmcapp.logic.dtos.utilities;

public class CredentialsDto {

    private String _alias;
    private String _clave;


    public CredentialsDto(){

    }

    public CredentialsDto(String alias, String clave) {
        this._alias = alias;
        this._clave = clave;
    }

    public String getAlias() {
        return _alias;
    }

    public void setUsername(String alias) {
        this._alias = alias;
    }

    public String getClave() {
        return _clave;
    }

    public void setPassword(String clave) {
        this._clave = clave;
    }

    @Override
    public String toString() {
        return "CredentialsDto{" +
                "alias='" + _alias + '\'' +
                ", clave='" + _clave + '\'' +
                '}';
    }
}
