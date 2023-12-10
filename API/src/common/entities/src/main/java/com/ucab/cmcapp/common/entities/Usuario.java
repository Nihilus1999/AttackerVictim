package com.ucab.cmcapp.common.entities;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {



    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "nombre", nullable = false)
    private String _nombre;

    @Column(name = "apellido", nullable = false)
    private String _apellido;

    @Column(name = "alias", nullable = false, unique = true)
    private String _alias;

    @Column(name = "cedula", nullable = false, unique = true)
    private String _cedula;

    @Column(name = "correo", nullable = false, unique = true)
    private String _correo;

    @Column(name = "direccion_mac", nullable = false, unique = true)
    private String _direccion_mac;

    @Column(name = "clave", nullable = false)
    private String _clave;

    /*@Basic(optional = false)
    @Column(name = "term_condition", insertable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean _termCondition;

    @Basic(optional = false)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date _createAt;*/


    @Column(name = "activate", nullable = false, insertable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean _activate;


    public Usuario() {

    }

    public Usuario(Usuario usuario) {
        _nombre = usuario._nombre;
        _apellido = usuario._apellido;
        _alias = usuario._alias;
        _cedula = usuario._cedula;
        _correo = usuario._correo;
        _direccion_mac = usuario._direccion_mac;
        _clave = usuario._clave;
        _activate = usuario._activate;
    }

    public Usuario(long id) {
        _id = id;
    }

    public Usuario(String alias) {
        _alias = alias;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_cedula() {
        return _cedula;
    }

    public void set_cedula(String _cedula) {
        this._cedula = _cedula;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    public String get_direccion_mac() {
        return _direccion_mac;
    }

    public void set_direccion_mac(String _direccion_mac) {
        this._direccion_mac = _direccion_mac;
    }

    public String get_clave() {
        return _clave;
    }

    public void set_clave(String _clave) {
        this._clave = _clave;
    }

    public Boolean get_activate() {
        return _activate;
    }

    public void set_activate(Boolean _activate) {
        this._activate = _activate;
    }
}
