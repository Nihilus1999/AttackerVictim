package com.ucab.cmcapp.logic.dtos;


public class CoordenadaDto extends BaseDto {

    private float _latitud;
    private float _longitud;



    public CoordenadaDto() {

    }

    public CoordenadaDto(long id) {
        super(id);
    }

    public float get_latitud() {
        return _latitud;
    }

    public void set_latitud(float _latitud) {
        this._latitud = _latitud;
    }

    public float get_longitud() {
        return _longitud;
    }

    public void set_longitud(float _longitud) {
        this._longitud = _longitud;
    }
}
