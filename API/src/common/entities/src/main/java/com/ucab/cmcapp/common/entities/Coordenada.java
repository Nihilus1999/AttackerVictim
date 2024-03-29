package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

import static javax.persistence.ConstraintMode.CONSTRAINT;

@Entity
@Table(name = "coordenadas")
public class Coordenada {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "latitud", nullable = false)
    private double _latitud;

    @Column(name = "longitud", nullable = false)
    private double _longitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_zona_segura", nullable = false)
    private Zona_Segura _zona_segura;

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

    public Zona_Segura get_zona_segura() {
        return _zona_segura;
    }

    public void set_zona_segura(Zona_Segura _zona_segura) {
        this._zona_segura = _zona_segura;
    }
}
