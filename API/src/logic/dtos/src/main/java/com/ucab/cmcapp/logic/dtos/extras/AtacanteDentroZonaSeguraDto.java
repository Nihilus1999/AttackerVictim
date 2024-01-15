package com.ucab.cmcapp.logic.dtos.extras;

import java.util.ArrayList;
import java.util.List;

public class AtacanteDentroZonaSeguraDto {

    private Boolean _dentro;

    private List<String> _zonas_seguras = new ArrayList<>();

    private Double _latitud;

    private Double _longitud;

    public AtacanteDentroZonaSeguraDto() {

    }

    public Boolean get_dentro() {
        return _dentro;
    }

    public void set_dentro(Boolean _dentro) {
        this._dentro = _dentro;
    }

    public List<String> get_zonas_seguras() {
        return _zonas_seguras;
    }


    public Double get_latitud() {
        return _latitud;
    }

    public void set_latitud(Double _latitud) {
        this._latitud = _latitud;
    }

    public Double get_longitud() {
        return _longitud;
    }

    public void set_longitud(Double _longitud) {
        this._longitud = _longitud;
    }

    public void set_zonas_seguras(List<String> zonasSeguras) {

    }
}
