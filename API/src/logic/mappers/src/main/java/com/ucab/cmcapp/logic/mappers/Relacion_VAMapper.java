package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.dtos.Relacion_VADto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Relacion_VAMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Relacion_VAMapper.class);

    public static Relacion_VA mapDtoToEntity(Relacion_VADto dto) throws ParseException {
        Relacion_VA entity = EntityFactory.createRelacion_VA();

        entity.set_id(dto.getId());
        entity.set_distancia(dto.get_distancia());

        if ( Objects.nonNull( dto.get_usuario_victima() ) ) {
            entity.set_usuario_victima( Usuario_VictimaMapper.mapDtoToEntity( dto.get_usuario_victima() ) );
        }

        if ( Objects.nonNull( dto.get_usuario_atacante() ) ) {
            entity.set_usuario_atacante(Usuario_AtacanteMapper.mapDtoToEntity( dto.get_usuario_atacante() ) );
        }



        return entity;
    }

    public static Relacion_VADto mapEntityToDto(Relacion_VA entity) {
        final Relacion_VADto dto = new Relacion_VADto();


        dto.setId(entity.get_id());
        dto.set_distancia(entity.get_distancia());

        if(Objects.nonNull(entity.get_usuario_victima()))
            dto.set_usuario_victima( Usuario_VictimaMapper.mapEntityToDto( entity.get_usuario_victima()));

        if(Objects.nonNull(entity.get_usuario_atacante()))
            dto.set_usuario_atacante( Usuario_AtacanteMapper.mapEntityToDto( entity.get_usuario_atacante()));

        return dto;
    }

    public static Relacion_VA mapDtoToEntity(long id) {
        Relacion_VA entity = EntityFactory.createRelacion_VA(id);
        entity.set_id(id);
        return entity;
    }

    public static List<Relacion_VADto> mapEntityListToDtoList(List<Relacion_VA> entityList){
        List<Relacion_VADto> dtoList = new ArrayList<Relacion_VADto>();
        Relacion_VADto Relacion_VADto;

        for (Relacion_VA relacionUsuario : entityList) {

            Relacion_VADto = new Relacion_VADto();
            Relacion_VADto.setId(relacionUsuario.get_id());
            Relacion_VADto.set_distancia(relacionUsuario.get_distancia());

            if (Objects.nonNull(relacionUsuario.get_usuario_victima()))
                Relacion_VADto.set_usuario_victima(Usuario_VictimaMapper.mapEntityToDto(relacionUsuario.get_usuario_victima()));

            if (Objects.nonNull(relacionUsuario.get_usuario_atacante()))
                Relacion_VADto.set_usuario_atacante(Usuario_AtacanteMapper.mapEntityToDto(relacionUsuario.get_usuario_atacante()));


            dtoList.add(Relacion_VADto);

        }

        return dtoList;
    }

}
