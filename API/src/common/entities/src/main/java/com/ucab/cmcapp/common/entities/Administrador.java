package com.ucab.cmcapp.common.entities;

import javax.persistence.*;


@Entity
@Table(name = "administrador")
public class Administrador {



    @Id
    @Column(name = "id_administrador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "alias", nullable = false, unique = true)
    private String _alias;

    @Column(name = "correo", nullable = false, unique = true)
    private String _correo;

    @Column(name = "clave", nullable = false, unique = true)
    private String _clave;

    /*@Basic(optional = false)
    @Column(name = "term_condition", insertable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean _termCondition;

    @Basic(optional = false)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date _createAt;*/


    public Administrador() {

    }

    public Administrador(Administrador usuario) {
        _alias = usuario._alias;
        _correo = usuario._correo;
        _clave = usuario._clave;
    }

    public Administrador(long id) {
        _id = id;
    }

    public Administrador(String alias) {
        _alias = alias;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }


    public String get_clave() {
        return _clave;
    }

    public void set_clave(String _clave) {
        this._clave = _clave;
    }

}
