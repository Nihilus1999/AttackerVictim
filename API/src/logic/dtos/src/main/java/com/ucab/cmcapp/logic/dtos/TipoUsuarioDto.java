package com.ucab.cmcapp.logic.dtos;

public class TipoUsuarioDto extends BaseDto {
    private String _descripcion;

    public TipoUsuarioDto() {
    }

    public TipoUsuarioDto(long id) {
        super(id);
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;
    }

}
