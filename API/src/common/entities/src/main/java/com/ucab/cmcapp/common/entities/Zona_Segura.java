package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "zona_segura")
public class Zona_Segura {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "nombre", nullable = false)
    private String _nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario_victima", nullable = false )
    private Usuario_Victima _victima;


    public Zona_Segura() {

    }

    public Zona_Segura(Zona_Segura usuario) {
        _nombre = usuario._nombre;
    }

    public Zona_Segura(long id) {
        _id = id;
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

    public Usuario_Victima get_victima() {
        return _victima;
    }

    public void set_victima(Usuario_Victima _victima) {
        this._victima = _victima;
    }
}
