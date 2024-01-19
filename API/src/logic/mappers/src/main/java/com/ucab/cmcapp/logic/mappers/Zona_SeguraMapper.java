package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La clase Zona_SeguraMapper proporciona métodos para mapear objetos Zona_Segura y Zona_SeguraDto entre sí.
 */
public class Zona_SeguraMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Zona_SeguraMapper.class);

    /**
     * Convierte un objeto Zona_SeguraDto en un objeto Zona_Segura.
     *
     * @param dto el objeto Zona_SeguraDto a convertir.
     * @return el objeto Zona_Segura resultante.
     * @throws ParseException si ocurre un error al analizar una fecha.
     */
    public static Zona_Segura mapDtoToEntity(Zona_SeguraDto dto) throws ParseException {
        Zona_Segura entity = EntityFactory.createZona_Segura();

        entity.set_id(dto.getId());
        entity.set_nombre(dto.get_nombre());

        if (Objects.nonNull(dto.get_victima())) {
            entity.set_victima(Usuario_VictimaMapper.mapDtoToEntity(dto.get_victima()));
        }

        return entity;
    }

    /**
     * Convierte un objeto Zona_Segura en un objeto Zona_SeguraDto.
     *
     * @param entity el objeto Zona_Segura a convertir.
     * @return el objeto Zona_SeguraDto resultante.
     */
    public static Zona_SeguraDto mapEntityToDto(Zona_Segura entity) {
        final Zona_SeguraDto dto = new Zona_SeguraDto();

        dto.setId(entity.get_id());
        dto.set_nombre(entity.get_nombre());

        if (Objects.nonNull(entity.get_victima())) {
            dto.set_victima(Usuario_VictimaMapper.mapEntityToDto(entity.get_victima()));
        }

        return dto;
    }

    /**
     * Convierte un ID de Zona_Segura en un objeto Zona_Segura.
     *
     * @param id el ID de Zona_Segura.
     * @return el objeto Zona_Segura resultante.
     */
    public static Zona_Segura mapDtoToEntity(long id) {
        Zona_Segura entity = EntityFactory.createZona_Segura(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos Zona_Segura en una lista de objetos Zona_SeguraDto.
     *
     * @param entityList la lista de objetos Zona_Segura a convertir.
     * @return la lista de objetos Zona_SeguraDto resultante.
     */
    public static List<Zona_SeguraDto> mapEntityListToDtoList(List<Zona_Segura> entityList) {
        List<Zona_SeguraDto> dtoList = new ArrayList<>();
        Zona_SeguraDto zonaSeguraDto;

        for (Zona_Segura zonaSegura : entityList) {
            zonaSeguraDto = new Zona_SeguraDto();
            zonaSeguraDto.setId(zonaSegura.get_id());
            zonaSeguraDto.set_nombre(zonaSegura.get_nombre());

            if (Objects.nonNull(zonaSegura.get_victima())) {
                zonaSeguraDto.set_victima(Usuario_VictimaMapper.mapEntityToDto(zonaSegura.get_victima()));
            }

            dtoList.add(zonaSeguraDto);
        }

        return dtoList;
    }

    /**
     * Crea un objeto Zona_Segura con el ID de un usuario.
     *
     * @param usuarioId el ID del usuario.
     * @return el objeto Zona_Segura resultante.
     */
    public static Zona_Segura mapDtoToEntityUsuarioId(long usuarioId) {
        Usuario_Victima victima = new Usuario_Victima(usuarioId);
        Zona_Segura zonaSegura = EntityFactory.createZona_Segura();
        zonaSegura.set_victima(victima);
        return zonaSegura;
    }
}