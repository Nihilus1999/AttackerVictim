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

public class Zona_SeguraMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Zona_SeguraMapper.class);

    /**
     * Mapea un objeto Zona_SeguraDto a una entidad Zona_Segura.
     *
     * @param dto El objeto Zona_SeguraDto que se va a mapear.
     * @return La entidad Zona_Segura mapeada.
     * @throws ParseException Si se produce un error al analizar el objeto.
     */
    public static Zona_Segura mapDtoToEntity(Zona_SeguraDto dto) throws ParseException {
        Zona_Segura entity = EntityFactory.createZona_Segura();

        _logger.debug( "Tomar en AdministradorMapper.mapDtoToEntity: dto {}", dto );

        entity.set_id(dto.getId());
        entity.set_nombre(dto.get_nombre());

        if ( Objects.nonNull( dto.get_victima() ) ) {
            entity.set_victima( Usuario_VictimaMapper.mapDtoToEntity( dto.get_victima() ) );
        }

        return entity;
    }

    /**
     * Mapea una entidad Zona_Segura a un objeto Zona_SeguraDto.
     *
     * @param entity La entidad Zona_Segura que se va a mapear.
     * @return El objeto Zona_SeguraDto mapeado.
     */
    public static Zona_SeguraDto mapEntityToDto(Zona_Segura entity) {
        final Zona_SeguraDto dto = new Zona_SeguraDto();

        _logger.debug( "Tomar en Zona_SeguraMapper.mapDtoToEntity: dto {}", dto );

        dto.setId(entity.get_id());
        dto.set_nombre(entity.get_nombre());

        if(Objects.nonNull(entity.get_victima()))
            dto.set_victima( Usuario_VictimaMapper.mapEntityToDto( entity.get_victima() ) );

        return dto;
    }

    /**
     * Mapea un id a una entidad Zona_Segura.
     *
     * @param id El id que se va a mapear.
     * @return La entidad Zona_Segura mapeada.
     */
    public static Zona_Segura mapDtoToEntity(long id) {

        _logger.debug( "Tomar en Zona_SeguraMapper.mapDtoToEntity: dto {}", id );

        Zona_Segura entity = EntityFactory.createZona_Segura(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Mapea una lista de entidades Zona_Segura a una lista de objetos Zona_SeguraDto.
     *
     * @param entityList La lista de entidades Zona_Segura que se va a mapear.
     * @return La lista de objetos Zona_SeguraDto mapeados.
     */
    public static List<Zona_SeguraDto> mapEntityListToDtoList(List<Zona_Segura> entityList){
        List<Zona_SeguraDto> dtoList = new ArrayList<Zona_SeguraDto>();
        Zona_SeguraDto Zona_SeguraDto;

        _logger.debug( "Tomar en Zona_SeguraMapper.mapDtoToEntity: dto {}", dtoList );

        for (Zona_Segura zonasSegura : entityList) {

            Zona_SeguraDto = new Zona_SeguraDto();
            Zona_SeguraDto.setId(zonasSegura.get_id());
            Zona_SeguraDto.set_nombre(zonasSegura.get_nombre());

            if (Objects.nonNull(zonasSegura.get_victima()))
                Zona_SeguraDto.set_victima(Usuario_VictimaMapper.mapEntityToDto(zonasSegura.get_victima()));

            dtoList.add(Zona_SeguraDto);

        }

        return dtoList;
    }

    /**
     * Mapea un id de usuario a una entidad Zona_Segura.
     *
     * @param usuarioId El id del usuario que se va a mapear.
     * @return La entidad Zona_Segura mapeada.
     */
    public static Zona_Segura mapDtoToEntityUsuarioId(long usuarioId){

        _logger.debug( "Tomar en Zona_SeguraMapper.mapDtoToEntity: dto {}", usuarioId );

        Usuario_Victima victima = new Usuario_Victima(usuarioId);
        Zona_Segura zonaSegura = EntityFactory.createZona_Segura();
        zonaSegura.set_victima(victima);
        return zonaSegura;
    }

}
