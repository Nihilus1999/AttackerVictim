package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.NotificacionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que proporciona métodos estáticos para mapear entre objetos Notificacion y NotificacionDto.
 */
public class NotificacionMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(NotificacionMapper.class);

    /**
     * Convierte un objeto NotificacionDto en un objeto Notificacion.
     *
     * @param dto el objeto NotificacionDto a convertir.
     * @return el objeto Notificacion resultante.
     * @throws ParseException si se produce un error durante el análisis.
     */
    public static Notificacion mapDtoToEntity(NotificacionDto dto) throws ParseException {
        Notificacion entity = EntityFactory.createNotificacion();

        entity.set_id(dto.getId());
        entity.set_tipo(dto.get_tipo());
        entity.set_fecha(dto.get_fecha());
        entity.set_descripcion(dto.get_descripcion());

        if (Objects.nonNull(dto.get_usuario())) {
            entity.set_usuario(UsuarioMapper.mapDtoToEntity(dto.get_usuario()));
        }

        return entity;
    }

    /**
     * Convierte un objeto Notificacion en un objeto NotificacionDto.
     *
     * @param entity el objeto Notificacion a convertir.
     * @return el objeto NotificacionDto resultante.
     */
    public static NotificacionDto mapEntityToDto(Notificacion entity) {
        final NotificacionDto dto = new NotificacionDto();

        dto.setId(entity.get_id());
        dto.set_tipo(entity.get_tipo());
        dto.set_fecha(entity.get_fecha());
        dto.set_descripcion(entity.get_descripcion());

        if (Objects.nonNull(entity.get_usuario()))
            dto.set_usuario(UsuarioMapper.mapEntityToDto(entity.get_usuario()));

        return dto;
    }

    /**
     * Convierte un objeto NotificacionDto en un objeto Notificacion con el ID especificado.
     *
     * @param id el ID de la notificación.
     * @return el objeto Notificacion resultante con el ID especificado.
     */
    public static Notificacion mapDtoToEntity(long id) {
        Notificacion entity = EntityFactory.createNotificacion(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Convierte una lista de objetos Notificacion en una lista de objetos NotificacionDto.
     *
     * @param entityList la lista de objetos Notificacion.
     * @return la lista de objetos NotificacionDto resultante.
     */
    public static List<NotificacionDto> mapEntityListToDtoList(List<Notificacion> entityList) {
        List<NotificacionDto> dtoList = new ArrayList<>();
        NotificacionDto notificacionDto;

        for (Notificacion notificacion : entityList) {
            notificacionDto = new NotificacionDto();
            notificacionDto.setId(notificacion.get_id());
            notificacionDto.set_tipo(notificacion.get_tipo());
            notificacionDto.set_fecha(notificacion.get_fecha());
            notificacionDto.set_descripcion(notificacion.get_descripcion());

            if (Objects.nonNull(notificacion.get_usuario()))
                notificacionDto.set_usuario(UsuarioMapper.mapEntityToDto(notificacion.get_usuario()));

            dtoList.add(notificacionDto);
        }

        return dtoList;
    }

    /**
     * Crea un objeto Notificacion con el ID de un Usuario.
     *
     * @param usuarioId el ID del Usuario.
     * @return el objeto Notificacion resultante con el Usuario asociado.
     */
    public static Notificacion mapDtoToEntityUsuarioId(long usuarioId) {
        Usuario usuario = new Usuario(usuarioId);
        Notificacion notificacion = EntityFactory.createNotificacion();
        notificacion.set_usuario(usuario);
        return notificacion;
    }
}