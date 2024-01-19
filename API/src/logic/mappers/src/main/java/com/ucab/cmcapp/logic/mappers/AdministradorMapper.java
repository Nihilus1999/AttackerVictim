package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(AdministradorMapper.class);


    /**
     * Convierte un objeto `AdministradorDto` en un objeto `Administrador` correspondiente.
     *
     * @param dto Objeto `AdministradorDto` a convertir.
     * @return Objeto `Administrador` convertido.
     * @throws ParseException Si se produce un error al analizar una fecha en el proceso de conversión.
     */
    public static Administrador mapDtoToEntity(AdministradorDto dto) throws ParseException {
        Administrador entity = EntityFactory.createAdministrador();

        _logger.debug( "Tomar en AdministradorMapper.mapDtoToEntity: dto {}", dto );

        entity.set_id(dto.getId());
        entity.set_alias(dto.get_alias());
        entity.set_correo(dto.get_correo());
        entity.set_clave(dto.get_clave());

        return entity;
    }

    /**
     * Convierte un objeto `Administrador` en un objeto `AdministradorDto` correspondiente.
     *
     * @param entity Objeto `Administrador` a convertir.
     * @return Objeto `AdministradorDto` convertido.
     */
    public static AdministradorDto mapEntityToDto(Administrador entity) {
        final AdministradorDto dto = new AdministradorDto();

        _logger.debug( "Tomar en AdministradorMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.get_id());
        dto.set_alias(entity.get_alias());
        dto.set_correo(entity.get_correo());
        dto.set_clave(entity.get_clave());

        return dto;
    }

    /**
     * Crea un objeto `Administrador` a partir de un ID.
     *
     * @param id ID del administrador.
     * @return Objeto `Administrador` creado.
     */
    public static Administrador mapDtoToEntity(long id) {
        Administrador entity = EntityFactory.createAdministrador(id);

        _logger.debug( "Tomar en AdministradorMapper.mapDtoToEntity: id {}", id );

        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos `Administrador` en una lista de objetos `AdministradorDto` correspondientes.
     *
     * @param entityList Lista de objetos `Administrador` a convertir.
     * @return Lista de objetos `AdministradorDto` convertidos.
     */
    public static List<AdministradorDto> mapEntityListToDtoList(List<Administrador> entityList){
        List<AdministradorDto> dtoList = new ArrayList<AdministradorDto>();
        AdministradorDto AdministradorDto;

        _logger.debug( "Tomar en AdministradorMapper.mapEntityListToDtoList: entityList {}", entityList );

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

    /**
     * Crea un objeto `Administrador` a partir de una dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del administrador.
     * @return Objeto `Administrador` creado.
     */
    public static Administrador mapDtoToEntityCorreo(String email) {
        Administrador entity = EntityFactory.createAdministrador();

        _logger.debug( "Tomar en AdministradorMapper.mapDtoToEntityCorreo: email {}", email );

        entity.set_correo(email);
        return entity;
    }

    /**
     * Crea un objeto `Administrador` a partir de un alias.
     *
     * @param alias Alias del administrador.
     * @return Objeto `Administrador` creado.
     */
    public static Administrador mapDtoToEntityAlias(String alias){
        Administrador entity = EntityFactory.createAdministrador();

        _logger.debug( "Tomar en AdministradorMapper.mapDtoToEntityAlias: alias {}", alias );

        entity.set_alias(alias);
        return entity;
    }

}
