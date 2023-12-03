package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "usuario_atacante")
public class Usuario_Atacante {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario", nullable = false, unique = true)
    private Usuario _usuario;


    public Usuario_Atacante() {

    }

    public Usuario_Atacante(Usuario_Atacante usuario) {

    }

    public Usuario_Atacante(long id) {
        _id = id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
}
