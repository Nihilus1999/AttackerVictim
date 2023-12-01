package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoordenadaMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaMapper.class);

    public static Coordenada mapDtoToEntity(CoordenadaDto dto) throws ParseException {
        Coordenada entity = EntityFactory.createCoordenada();

        entity.set_id(dto.getId());
        entity.set_latitud(dto.get_latitud());
        entity.set_longitud(dto.get_longitud());

        return entity;
    }

    public static CoordenadaDto mapEntityToDto(Coordenada entity) {
        final CoordenadaDto dto = new CoordenadaDto();


        dto.setId(entity.get_id());
        dto.set_latitud(entity.get_latitud());
        dto.set_longitud(entity.get_longitud());

        return dto;
    }

    public static Coordenada mapDtoToEntity(long id) {
        Coordenada entity = EntityFactory.createCoordenada(id);
        entity.set_id(id);
        return entity;
    }

    public static List<CoordenadaDto> mapEntityListToDtoList(List<Coordenada> entityList){
        List<CoordenadaDto> dtoList = new ArrayList<CoordenadaDto>();
        CoordenadaDto coordenadaDto;

        for (Coordenada coordenada : entityList) {
            coordenadaDto = new CoordenadaDto();
            coordenadaDto.setId(coordenada.get_id());
            coordenadaDto.set_latitud(coordenada.get_latitud());
            coordenadaDto.set_longitud(coordenada.get_longitud());

            dtoList.add(coordenadaDto);
        }

        return dtoList;
    }

}
