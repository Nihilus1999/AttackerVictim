package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.TipoUsuario;
import com.ucab.cmcapp.logic.dtos.TipoUsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TipoUsuarioMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioMapper.class);

    public static TipoUsuario mapDtoToEntity(TipoUsuarioDto dto) {
        TipoUsuario entity = EntityFactory.createTipoUsuario(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug("Get in UsuarioMapper.mapDtoToEntity: dto {}", dto);
        //endregion

        entity.setName(dto.getDescripcion());

        //region Instrumentation DEBUG
        _logger.debug("Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity);
        //endregion

        return entity;
    }

    public static TipoUsuarioDto mapEntityToDto(TipoUsuario entity) {
        final TipoUsuarioDto dto = new TipoUsuarioDto();

        //region Instrumentation DEBUG
        _logger.debug("Get in UsuarioMapper.mapEntityToDto: entity {}", entity);
        //endregion

        dto.setId(entity.getId());
        dto.setDescripcion(entity.getName());

        //region Instrumentation DEBUG
        _logger.debug("Leaving UsuarioMapper.mapEntityToDto: dto {}", dto);
        //endregion

        return dto;
    }
}
