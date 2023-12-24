package com.ucab.cmcapp.logic.dtos.dtos;


public class Relacion_VADto extends BaseDto {

    private float _distancia;
    private Usuario_VictimaDto _usuario_victima;
    private Usuario_AtacanteDto _usuario_atacante;


    public Relacion_VADto() {

    }

    public Relacion_VADto(long id) {
        super(id);
    }

    public float get_distancia() {
        return _distancia;
    }

    public void set_distancia(float _distancia) {
        this._distancia = _distancia;
    }

    public Usuario_VictimaDto get_usuario_victima() {
        return _usuario_victima;
    }

    public void set_usuario_victima(Usuario_VictimaDto _usuario_victima) {
        this._usuario_victima = _usuario_victima;
    }

    public Usuario_AtacanteDto get_usuario_atacante() {
        return _usuario_atacante;
    }

    public void set_usuario_atacante(Usuario_AtacanteDto _usuario_atacante) {
        this._usuario_atacante = _usuario_atacante;
    }
}
