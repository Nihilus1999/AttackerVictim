package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.dtos.AdministradorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(AdministradorMapper.class);

    public static Administrador mapDtoToEntity(AdministradorDto dto) throws ParseException {
        Administrador entity = EntityFactory.createAdministrador();

        entity.set_id(dto.getId());
        entity.set_alias(dto.get_alias());
        entity.set_correo(dto.get_correo());
        entity.set_clave(dto.get_clave());

        return entity;
    }

    public static AdministradorDto mapEntityToDto(Administrador entity) {
        final AdministradorDto dto = new AdministradorDto();

        dto.setId(entity.get_id());
        dto.set_alias(entity.get_alias());
        dto.set_correo(entity.get_correo());
        dto.set_clave(entity.get_clave());

        return dto;
    }

    public static Administrador mapDtoToEntity(long id) {
        Administrador entity = EntityFactory.createAdministrador(id);
        entity.set_id(id);
        return entity;
    }

    public static List<AdministradorDto> mapEntityListToDtoList(List<Administrador> entityList){
        List<AdministradorDto> dtoList = new ArrayList<AdministradorDto>();
        AdministradorDto AdministradorDto;

        for (Administrador Administrador : entityList) {
            AdministradorDto = new AdministradorDto();
            AdministradorDto.setId(Administrador.get_id());
            AdministradorDto.set_alias(Administrador.get_alias());
            AdministradorDto.set_correo(Administrador.get_correo());
            AdministradorDto.set_clave(Administrador.get_clave());
            dtoList.add(AdministradorDto);
        }

        return dtoList;
    }

    public static Administrador mapDtoToEntityCorreo(String email) {
        Administrador entity = EntityFactory.createAdministrador();
        entity.set_correo(email);
        return entity;
    }

    public static Administrador mapDtoToEntityAlias(String alias){
        Administrador entity = EntityFactory.createAdministrador();
        entity.set_alias(alias);
        return entity;
    }

}
