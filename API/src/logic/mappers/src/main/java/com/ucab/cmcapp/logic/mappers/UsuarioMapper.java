package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioMapper.class);

    public static Usuario mapDtoToEntity(UsuarioDto dto) throws ParseException {
        Usuario entity = EntityFactory.createUsuario();

        entity.set_id(dto.getId());
        entity.set_nombre(dto.get_nombre());
        entity.set_apellido(dto.get_apellido());
        entity.set_alias(dto.get_alias());
        entity.set_cedula(dto.get_cedula());
        entity.set_correo(dto.get_correo());
        entity.set_direccion_mac(dto.get_direccion_mac());
        entity.set_clave(dto.get_clave());
        entity.set_activate(dto.get_activate());

        return entity;
    }

    public static UsuarioDto mapEntityToDto(Usuario entity) {
        final UsuarioDto dto = new UsuarioDto();


        dto.setId(entity.get_id());
        dto.set_nombre(entity.get_nombre());
        dto.set_apellido(entity.get_apellido());
        dto.set_alias(entity.get_alias());
        dto.set_cedula(entity.get_cedula());
        dto.set_correo(entity.get_correo());
        dto.set_direccion_mac(entity.get_direccion_mac());
        dto.set_clave(entity.get_clave());
        dto.set_activate(entity.get_activate());

        return dto;
    }

    public static Usuario mapDtoToEntity(long id) {
        Usuario entity = EntityFactory.createUsuario(id);
        entity.set_id(id);
        return entity;
    }

    public static List<UsuarioDto> mapEntityListToDtoList(List<Usuario> entityList){
        List<UsuarioDto> dtoList = new ArrayList<UsuarioDto>();
        UsuarioDto usuarioDto;

        for (Usuario usuario : entityList) {
            usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.get_id());
            usuarioDto.set_nombre(usuario.get_nombre());
            usuarioDto.set_apellido(usuario.get_apellido());
            usuarioDto.set_alias(usuario.get_alias());
            usuarioDto.set_cedula(usuario.get_cedula());
            usuarioDto.set_correo(usuario.get_correo());
            usuarioDto.set_direccion_mac(usuario.get_direccion_mac());
            usuarioDto.set_clave(usuario.get_clave());
            usuarioDto.set_activate(usuario.get_activate());
            dtoList.add(usuarioDto);
        }

        return dtoList;
    }

    public static Usuario mapDtoToEntityCorreo(String email) {
        Usuario entity = EntityFactory.createUsuario();
        entity.set_correo(email);
        return entity;
    }

    public static Usuario mapDtoToEntityAlias(String alias){
        Usuario entity = EntityFactory.createUsuario();
        entity.set_alias(alias);
        return entity;
    }

    public static Usuario mapDtoToEntityCedula(String cedula) {
        Usuario entity = EntityFactory.createUsuario();
        entity.set_cedula(cedula);
        return entity;
    }


    public static Usuario mapDtoToEntityMac(String mac) {
        Usuario entity = EntityFactory.createUsuario();
        entity.set_direccion_mac(mac);
        return entity;
    }

}