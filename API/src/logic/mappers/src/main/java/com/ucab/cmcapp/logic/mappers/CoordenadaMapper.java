package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La clase CoordenadaMapper proporciona métodos estáticos para mapear entre objetos Coordenada y CoordenadaDto.
 */
public class CoordenadaMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaMapper.class);

    /**
     * Convierte un objeto CoordenadaDto en un objeto Coordenada.
     *
     * @param dto el objeto CoordenadaDto a convertir.
     * @return el objeto Coordenada resultante.
     * @throws ParseException si se produce un error durante el análisis.
     */
    public static Coordenada mapDtoToEntity(CoordenadaDto dto) throws ParseException {
        Coordenada entity = EntityFactory.createCoordenada();

        entity.set_id(dto.getId());
        entity.set_latitud(dto.get_latitud());
        entity.set_longitud(dto.get_longitud());

        if (Objects.nonNull(dto.get_zona_segura())) {
            entity.set_zona_segura(Zona_SeguraMapper.mapDtoToEntity(dto.get_zona_segura()));
        }

        return entity;
    }

    /**
     * Convierte un objeto Coordenada en un objeto CoordenadaDto.
     *
     * @param entity el objeto Coordenada a convertir.
     * @return el objeto CoordenadaDto resultante.
     */
    public static CoordenadaDto mapEntityToDto(Coordenada entity) {
        final CoordenadaDto dto = new CoordenadaDto();

        dto.setId(entity.get_id());
        dto.set_latitud(entity.get_latitud());
        dto.set_longitud(entity.get_longitud());

        if (Objects.nonNull(entity.get_zona_segura()))
            dto.set_zona_segura(Zona_SeguraMapper.mapEntityToDto(entity.get_zona_segura()));

        return dto;
    }

    /**
     * Convierte un ID de Coordenada en un objeto Coordenada.
     *
     * @param id el ID de Coordenada.
     * @return el objeto Coordenada resultante.
     */
    public static Coordenada mapDtoToEntity(long id) {
        Coordenada entity = EntityFactory.createCoordenada(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos Coordenada en una lista de objetos CoordenadaDto.
     *
     * @param entityList la lista de objetos Coordenada.
     * @return la lista de objetos CoordenadaDto resultante.
     */
    public static List<CoordenadaDto> mapEntityListToDtoList(List<Coordenada> entityList) {
        List<CoordenadaDto> dtoList = new ArrayList<CoordenadaDto>();
        CoordenadaDto coordenadaDto;

        for (Coordenada coordenada : entityList) {
            coordenadaDto = new CoordenadaDto();
            coordenadaDto.setId(coordenada.get_id());
            coordenadaDto.set_latitud(coordenada.get_latitud());
            coordenadaDto.set_longitud(coordenada.get_longitud());

            if (Objects.nonNull(coordenada.get_zona_segura()))
                coordenadaDto.set_zona_segura(Zona_SeguraMapper.mapEntityToDto(coordenada.get_zona_segura()));

            dtoList.add(coordenadaDto);
        }

        return dtoList;
    }

    /**
     * Crea un objeto Coordenada con el ID de una Zona Segura.
     *
     * @param zonaId el ID de la Zona Segura.
     * @return el objeto Coordenada resultante con la Zona Segura asociada.
     */
    public static Coordenada mapDtoToEntityZonaId(long zonaId) {
        Zona_Segura zona = new Zona_Segura(zonaId);
        Coordenada coordenada = EntityFactory.createCoordenada();
        coordenada.set_zona_segura(zona);
        return coordenada;
    }
}