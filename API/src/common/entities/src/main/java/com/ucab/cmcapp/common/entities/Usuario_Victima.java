package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "usuario_victima", uniqueConstraints = @UniqueConstraint(columnNames = "id_usuario"))
public class Usuario_Victima {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_usuario")
    private Usuario _usuario;


    public Usuario_Victima() {

    }

    public Usuario_Victima(Usuario_Victima usuario) {

    }

    public Usuario_Victima(long id) {
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
