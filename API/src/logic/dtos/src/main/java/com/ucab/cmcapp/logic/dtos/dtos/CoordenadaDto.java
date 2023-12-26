package com.ucab.cmcapp.logic.dtos.dtos;


public class CoordenadaDto extends BaseDto {

    private double _latitud;
    private double _longitud;

    private Zona_SeguraDto _zona_segura;



    public CoordenadaDto() {

    }

    public CoordenadaDto(long id) {
        super(id);
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

    public Zona_SeguraDto get_zona_segura() {
        return _zona_segura;
    }
    public void set_zona_segura(Zona_SeguraDto _zona_segura) {
        this._zona_segura = _zona_segura;
    }
}
