package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "descripcion", nullable = false)
    private String _descripcion;

    public TipoUsuario() {

    }

    public TipoUsuario(long id) {
        _id = id;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _descripcion;
    }

    public void setName(String descripcion) {
        _descripcion = descripcion;
    }
}
