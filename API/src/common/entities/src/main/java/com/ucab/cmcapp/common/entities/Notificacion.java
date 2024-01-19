package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "fecha", nullable = false)
    private Date _fecha;

    @Column(name = "tipo", nullable = false)
    private String _tipo;

    @Column(name = "descripcion", nullable = false)
    private String _descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario", nullable = false)
    private Usuario _usuario;

    public Notificacion() {

    }

    public Notificacion(Notificacion notificacion) {
        _tipo = notificacion._tipo;
        _fecha = notificacion._fecha;
        _descripcion = notificacion._descripcion;
    }

    public Notificacion(long id) {
        _id = id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

}
