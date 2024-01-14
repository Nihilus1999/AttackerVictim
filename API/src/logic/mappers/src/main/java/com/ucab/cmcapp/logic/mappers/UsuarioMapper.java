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

    /**
     * Mapea un objeto `UsuarioDto` a una entidad `Usuario`.
     *
     * @param dto El objeto `UsuarioDto` a mapear.
     * @return La entidad `Usuario` mapeada.
     * @throws ParseException Si ocurre un error al parsear los datos.
     */
    public static Usuario mapDtoToEntity(UsuarioDto dto) throws ParseException {
        Usuario entity = EntityFactory.createUsuario();

        _logger.debug( "Tomar en UsuarioMapper.mapDtoToEntity: dto {}", dto );

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

    /**
     * Mapea una entidad `Usuario` a un objeto `UsuarioDto`.
     *
     * @param entity La entidad `Usuario` a mapear.
     * @return El objeto `UsuarioDto` mapeado.
     */
    public static UsuarioDto mapEntityToDto(Usuario entity) {
        final UsuarioDto dto = new UsuarioDto();

        _logger.debug( "Tomar en UsuarioMapper.mapEntityToDto: entity {}", entity );


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

    /**
     * Crea una entidad `Usuario` con el ID especificado.
     *
     * @param id El ID para la entidad `Usuario`.
     * @return La entidad `Usuario` creada.
     */
    public static Usuario mapDtoToEntity(long id) {

        _logger.debug( "Tomar en UsuarioMapper.mapDtoToEntity: id {}", id );


        Usuario entity = EntityFactory.createUsuario(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Mapea una lista de entidades `Usuario` a una lista de objetos `UsuarioDto`.
     *
     * @param entityList La lista de entidades `Usuario` a mapear.
     * @return La lista de objetos `UsuarioDto` mapeada.
     */
    public static List<UsuarioDto> mapEntityListToDtoList(List<Usuario> entityList){
        List<UsuarioDto> dtoList = new ArrayList<UsuarioDto>();
        UsuarioDto usuarioDto;

        _logger.debug( "Tomar en UsuarioMapper.mapEntityListToDtoList: entityList {}", entityList );

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

    /**
     * Crea una entidad `Usuario` con el correo electrónico especificado.
     *
     * @param email El correo electrónico para la entidad `Usuario`.
     * @return La entidad `Usuario` creada.
     */
    public static Usuario mapDtoToEntityCorreo(String email) {

        _logger.debug( "Tomar en UsuariorMapper.mapDtoToEntityCorreo: email {}", email );

        Usuario entity = EntityFactory.createUsuario();
        entity.set_correo(email);
        return entity;
    }

    /**
     * Crea una entidad `Usuario` con el alias especificado.
     *
     * @param alias El alias para la entidad `Usuario`.
     * @return La entidad `Usuario` creada.
     */
    public static Usuario mapDtoToEntityAlias(String alias){

        _logger.debug( "Tomar en UsuarioMapper.mapDtoToEntityAlias: email {}", alias );

        Usuario entity = EntityFactory.createUsuario();
        entity.set_alias(alias);
        return entity;
    }

    /**
     * Crea una entidad `Usuario` con la cédula especificada.
     *
     * @param cedula La cédula para la entidad `Usuario`.
     * @return La entidad `Usuario` creada.
     */
    public static Usuario mapDtoToEntityCedula(String cedula) {

        _logger.debug( "Tomar en UsuarioMapper.mapDtoToEntityCedula: email {}", cedula );

        Usuario entity = EntityFactory.createUsuario();
        entity.set_cedula(cedula);
        return entity;
    }

    /**
     * Crea una entidad `Usuario` con la dirección MAC especificada.
     *
     * @param mac La dirección MAC para la entidad `Usuario`.
     * @return La entidad `Usuario` creada.
     */
    public static Usuario mapDtoToEntityMac(String mac) {

        _logger.debug( "Tomar en UsuarioMapper.mapDtoToEntityMac: email {}", mac );

        Usuario entity = EntityFactory.createUsuario();
        entity.set_direccion_mac(mac);
        return entity;
    }

}
