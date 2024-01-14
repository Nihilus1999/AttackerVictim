package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.dtos.dtos.Relacion_VADto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Relacion_VAMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Relacion_VAMapper.class);

    /**
     * Convierte un objeto `Relacion_VADto` en un objeto `Relacion_VA` correspondiente para guardar en la base de datos.
     *
     * @param dto Objeto `Relacion_VADto` a convertir.
     * @return Objeto `Relacion_VA` convertido.
     * @throws ParseException Si se produce un error al analizar una fecha en el proceso de conversión.
     */
    public static Relacion_VA mapDtoToEntity(Relacion_VADto dto) throws ParseException {
        Relacion_VA entity = EntityFactory.createRelacion_VA();

        _logger.debug( "Tomar en Relacion_VAMapper.mapDtoToEntity: dto {}", dto );

        entity.set_id(dto.getId());
        entity.set_distancia(dto.get_distancia());
        entity.set_tiempo(dto.get_tiempo());

        if ( Objects.nonNull( dto.get_usuario_victima() ) ) {
            entity.set_usuario_victima( Usuario_VictimaMapper.mapDtoToEntity( dto.get_usuario_victima() ) );
        }

        if ( Objects.nonNull( dto.get_usuario_atacante() ) ) {
            entity.set_usuario_atacante(Usuario_AtacanteMapper.mapDtoToEntity( dto.get_usuario_atacante() ) );
        }

        _logger.debug( "Dejando Relacion_VAMapper.mapDtoToEntity: dto {}", entity);

        return entity;
    }

    /**
     * Convierte un objeto `Relacion_VA` en un objeto `Relacion_VADto` correspondiente para usar en el endpoint.
     *
     * @param entity Objeto `Relacion_VA` a convertir.
     * @return Objeto `Relacion_VADto` convertido.
     */
    public static Relacion_VADto mapEntityToDto(Relacion_VA entity) {
        final Relacion_VADto dto = new Relacion_VADto();

        _logger.debug( "Tomar en Relacion_VAMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.get_id());
        dto.set_distancia(entity.get_distancia());
        dto.set_tiempo(entity.get_tiempo());

        if(Objects.nonNull(entity.get_usuario_victima()))
            dto.set_usuario_victima( Usuario_VictimaMapper.mapEntityToDto( entity.get_usuario_victima()));

        if(Objects.nonNull(entity.get_usuario_atacante()))
            dto.set_usuario_atacante( Usuario_AtacanteMapper.mapEntityToDto( entity.get_usuario_atacante()));

        return dto;
    }

    /**
     * Crea un objeto `Relacion_VA` a partir de un ID.
     *
     * @param id ID de la relación.
     * @return Objeto `Relacion_VA` creado.
     */
    public static Relacion_VA mapDtoToEntity(long id) {
        Relacion_VA entity = EntityFactory.createRelacion_VA(id);

        _logger.debug( "Tomar en Relacion_VAMapper.mapDtoToEntity: id {}", id );

        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos `Relacion_VA` en una lista de objetos `Relacion_VADto` correspondientes para usar en el endpoint.
     *
     * @param entityList Lista de objetos `Relacion_VA` a convertir.
     * @return Lista de objetos `Relacion_VADto` convertidos.
     */
    public static List<Relacion_VADto> mapEntityListToDtoList(List<Relacion_VA> entityList){
        List<Relacion_VADto> dtoList = new ArrayList<Relacion_VADto>();
        Relacion_VADto Relacion_VADto;

        _logger.debug( "Tomar en Relacion_VAMapper.mapEntityListToDtoList: entityList {}", entityList );

        for (Relacion_VA relacionUsuario : entityList) {

            Relacion_VADto = new Relacion_VADto();
            Relacion_VADto.setId(relacionUsuario.get_id());
            Relacion_VADto.set_distancia(relacionUsuario.get_distancia());
            Relacion_VADto.set_tiempo(relacionUsuario.get_tiempo());

            if (Objects.nonNull(relacionUsuario.get_usuario_victima()))
                Relacion_VADto.set_usuario_victima(Usuario_VictimaMapper.mapEntityToDto(relacionUsuario.get_usuario_victima()));

            if (Objects.nonNull(relacionUsuario.get_usuario_atacante()))
                Relacion_VADto.set_usuario_atacante(Usuario_AtacanteMapper.mapEntityToDto(relacionUsuario.get_usuario_atacante()));


            dtoList.add(Relacion_VADto);

        }

        _logger.debug( "Dejando Relacion_VAMapper.mapEntityListToDtoList: entityList {}", dtoList );


        return dtoList;
    }

}
