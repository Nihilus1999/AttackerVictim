package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "coordenadas")
public class Coordenada {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "latitud", nullable = false)
    private float _latitud;

    @Column(name = "longitud", nullable = false)
    private float _longitud;

    public Coordenada() {

    }

    public Coordenada(Coordenada coordenada) {
        _latitud = coordenada._latitud;
        _longitud = coordenada._longitud;
    }

    public Coordenada(long id) {
        _id = id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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
