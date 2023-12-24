package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "relacion_VA")
public class Relacion_VA {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "distancia", nullable = false)
    private float _distancia;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario_victima", nullable = false, unique = true)
    private Usuario_Victima _usuario_victima;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario_atacante", nullable = false, unique = true)
    private Usuario_Atacante _usuario_atacante;


    public Relacion_VA() {

    }

    public Relacion_VA(Relacion_VA usuario) {
        _distancia = usuario._distancia;
    }

    public Relacion_VA(long id) {
        _id = id;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public float get_distancia() {
        return _distancia;
    }

    public void set_distancia(float _distancia) {
        this._distancia = _distancia;
    }

    public Usuario_Victima get_usuario_victima() {
        return _usuario_victima;
    }

    public void set_usuario_victima(Usuario_Victima _usuario_victima) {
        this._usuario_victima = _usuario_victima;
    }

    public Usuario_Atacante get_usuario_atacante() {
        return _usuario_atacante;
    }

    public void set_usuario_atacante(Usuario_Atacante _usuario_atacante) {
        this._usuario_atacante = _usuario_atacante;
    }
}
