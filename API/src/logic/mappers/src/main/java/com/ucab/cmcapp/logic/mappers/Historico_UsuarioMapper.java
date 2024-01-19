package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La clase Historico_UsuarioMapper proporciona métodos estáticos para mapear entre objetos Historico_Usuario y Historico_UsuarioDto.
 */
public class Historico_UsuarioMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Historico_UsuarioMapper.class);

    /**
     * Convierte un objeto Historico_UsuarioDto en un objeto Historico_Usuario.
     *
     * @param dto el objeto Historico_UsuarioDto a convertir.
     * @return el objeto Historico_Usuario resultante.
     * @throws ParseException si se produce un error durante el análisis.
     */
    public static Historico_Usuario mapDtoToEntity(Historico_UsuarioDto dto) throws ParseException {
        Historico_Usuario entity = EntityFactory.createHistorico_Usuario();

        entity.set_id(dto.getId());
        entity.set_fecha(dto.get_fecha());
        entity.set_estadoConexion(dto.get_estadoConexion());
        entity.set_latitud(dto.get_latitud());
        entity.set_longitud(dto.get_longitud());

        if (Objects.nonNull(dto.get_usuario())) {
            entity.set_usuario(UsuarioMapper.mapDtoToEntity(dto.get_usuario()));
        }

        return entity;
    }

    /**
     * Convierte un objeto Historico_Usuario en un objeto Historico_UsuarioDto.
     *
     * @param entity el objeto Historico_Usuario a convertir.
     * @return el objeto Historico_UsuarioDto resultante.
     */
    public static Historico_UsuarioDto mapEntityToDto(Historico_Usuario entity) {
        final Historico_UsuarioDto dto = new Historico_UsuarioDto();

        dto.setId(entity.get_id());
        dto.set_fecha(entity.get_fecha());
        dto.set_estadoConexion(entity.get_estadoConexion());
        dto.set_latitud(entity.get_latitud());
        dto.set_longitud(entity.get_longitud());

        if (Objects.nonNull(entity.get_usuario()))
            dto.set_usuario(UsuarioMapper.mapEntityToDto(entity.get_usuario()));

        return dto;
    }

    /**
     * Convierte un ID de Historico_Usuario en un objeto Historico_Usuario.
     *
     * @param id el ID de Historico_Usuario.
     * @return el objeto Historico_Usuario resultante.
     */
    public static Historico_Usuario mapDtoToEntity(long id) {
        Historico_Usuario entity = EntityFactory.createHistorico_Usuario(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos Historico_Usuario en una lista de objetos Historico_UsuarioDto.
     *
     * @param entityList la lista de objetos Historico_Usuario.
     * @return la lista de objetos Historico_UsuarioDto resultante.
     */
    public static List<Historico_UsuarioDto> mapEntityListToDtoList(List<Historico_Usuario> entityList) {
        List<Historico_UsuarioDto> dtoList = new ArrayList<Historico_UsuarioDto>();
        Historico_UsuarioDto historico_usuarioDto;

        for (Historico_Usuario historicoUsuario : entityList) {
            historico_usuarioDto = new Historico_UsuarioDto();
            historico_usuarioDto.setId(historicoUsuario.get_id());
            historico_usuarioDto.set_fecha(historicoUsuario.get_fecha());
            historico_usuarioDto.set_estadoConexion(historicoUsuario.get_estadoConexion());
            historico_usuarioDto.set_latitud(historicoUsuario.get_latitud());
            historico_usuarioDto.set_longitud(historicoUsuario.get_longitud());

            if (Objects.nonNull(historicoUsuario.get_usuario()))
                historico_usuarioDto.set_usuario(UsuarioMapper.mapEntityToDto(historicoUsuario.get_usuario()));

            dtoList.add(historico_usuarioDto);
        }

        return dtoList;
    }

    /**
     * Crea un objeto Historico_Usuario con el ID de un Usuario.
     *
     * @param usuarioId el ID del Usuario.
     * @return el objeto Historico_Usuario resultante con el Usuario asociado.
     */
    public static Historico_Usuario mapDtoToEntityUsuarioId(long usuarioId) {
        Usuario usuario = new Usuario(usuarioId);
        Historico_Usuario historico = EntityFactory.createHistorico_Usuario();
        historico.set_usuario(usuario);
        return historico;
    }
}