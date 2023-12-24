package com.ucab.cmcapp.logic.dtos.dtos;


public class Zona_SeguraDto extends BaseDto {

    private String _nombre;

    private Usuario_VictimaDto _victima;

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

    public Usuario_VictimaDto get_victima() {
        return _victima;
    }

    public void set_victima(Usuario_VictimaDto _victima) {
        this._victima = _victima;
    }
}
