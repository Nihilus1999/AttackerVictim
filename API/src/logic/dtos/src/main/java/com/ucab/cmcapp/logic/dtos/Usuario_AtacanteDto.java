package com.ucab.cmcapp.logic.dtos;


public class Usuario_AtacanteDto extends BaseDto {

    private UsuarioDto _usuario;


    public Usuario_AtacanteDto() {

    }

    public Usuario_AtacanteDto(long id) {
        super(id);
    }

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
