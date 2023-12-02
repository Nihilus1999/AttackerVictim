package com.ucab.cmcapp.common.entities;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "historico_usuario")
public class Historico_Usuario {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "fecha", nullable = false)
    private Date _fecha;

    @Column(name = "estadoConexion", nullable = false)
    private Boolean _estadoConexion;

    @Column(name = "latitud", nullable = false, unique = true)
    private float _latitud;

    @Column(name = "longitud", nullable = false, unique = true)
    private float _longitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario", nullable = false )
    private Usuario _usuario;


    public Historico_Usuario() {

    }

    public Historico_Usuario(Historico_Usuario usuario) {
        _fecha = usuario._fecha;
        _estadoConexion = usuario._estadoConexion;
        _latitud = usuario._latitud;
        _longitud = usuario._longitud;

    }

    public Historico_Usuario(long id) {
        _id = id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Boolean get_estadoConexion() {
        return _estadoConexion;
    }

    public void set_estadoConexion(Boolean _estadoConexion) {
        this._estadoConexion = _estadoConexion;
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

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
}
