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

    public static Zona_Segura mapDtoToEntity(Zona_SeguraDto dto) throws ParseException {
        Zona_Segura entity = EntityFactory.createZona_Segura();

        entity.set_id(dto.getId());
        entity.set_nombre(dto.get_nombre());

        if ( Objects.nonNull( dto.get_victima() ) ) {
            entity.set_victima( Usuario_VictimaMapper.mapDtoToEntity( dto.get_victima() ) );
        }

        return entity;
    }

    public static Zona_SeguraDto mapEntityToDto(Zona_Segura entity) {
        final Zona_SeguraDto dto = new Zona_SeguraDto();

        dto.setId(entity.get_id());
        dto.set_nombre(entity.get_nombre());

        if(Objects.nonNull(entity.get_victima()))
            dto.get_victima(Usuario_VictimaMapper.mapEntityToDto(entity.));

        return dto;
    }

    public static Zona_Segura mapDtoToEntity(long id) {
        Zona_Segura entity = EntityFactory.createZona_Segura(id);
        entity.set_id(id);
        return entity;
    }

    public static List<Zona_SeguraDto> mapEntityListToDtoList(List<Zona_Segura> entityList){
        List<Zona_SeguraDto> dtoList = new ArrayList<Zona_SeguraDto>();
        Zona_SeguraDto Zona_SeguraDto;

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

    public static Zona_Segura mapDtoToEntityUsuarioId(long usuarioId){
        Usuario_Victima victima = new Usuario_Victima(usuarioId);
        Zona_Segura zonaSegura = EntityFactory.createZona_Segura();
        zonaSegura.set_victima(victima);
        return zonaSegura;
    }

}
