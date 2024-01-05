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

public class NotificacionMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(NotificacionMapper.class);

    public static Notificacion mapDtoToEntity(NotificacionDto dto) throws ParseException {
        Notificacion entity = EntityFactory.createNotificacion();

        entity.set_id(dto.getId());
        entity.set_tipo(dto.get_tipo());
        entity.set_descripcion(dto.get_descripcion());

        if ( Objects.nonNull( dto.get_usuario() ) ) {
            entity.set_usuario( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }

        return entity;
    }

    public static NotificacionDto mapEntityToDto(Notificacion entity) {
        final NotificacionDto dto = new NotificacionDto();


        dto.setId(entity.get_id());
        dto.set_tipo(entity.get_tipo());
        dto.set_descripcion(entity.get_descripcion());

        if(Objects.nonNull(entity.get_usuario()))
            dto.set_usuario( UsuarioMapper.mapEntityToDto( entity.get_usuario()));

        return dto;
    }

    public static Notificacion mapDtoToEntity(long id) {
        Notificacion entity = EntityFactory.createNotificacion(id);
        entity.set_id(id);
        return entity;
    }

    public static List<NotificacionDto> mapEntityListToDtoList(List<Notificacion> entityList){
        List<NotificacionDto> dtoList = new ArrayList<NotificacionDto>();
        NotificacionDto NotificacionDto;

        for (Notificacion historicoUsuario : entityList) {

            NotificacionDto = new NotificacionDto();
            NotificacionDto.setId(historicoUsuario.get_id());
            NotificacionDto.set_tipo(historicoUsuario.get_tipo());
            NotificacionDto.set_descripcion(historicoUsuario.get_descripcion());

            if (Objects.nonNull(historicoUsuario.get_usuario()))
                NotificacionDto.set_usuario(UsuarioMapper.mapEntityToDto(historicoUsuario.get_usuario()));

            dtoList.add(NotificacionDto);

        }

        return dtoList;
    }

    public static Notificacion mapDtoToEntityUsuarioId(long usuarioId){
        Usuario usuario = new Usuario(usuarioId);
        Notificacion historico = EntityFactory.createNotificacion();
        historico.set_usuario(usuario);
        return historico;
    }

}
