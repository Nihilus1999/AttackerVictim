package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario_VictimaMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Usuario_VictimaMapper.class);

    public static Usuario_Victima mapDtoToEntity(Usuario_VictimaDto dto) throws ParseException {
        Usuario_Victima entity = EntityFactory.createUsuario_Victima();

        entity.set_id(dto.getId());

        if (Objects.nonNull(dto.get_usuario())) {
            entity.set_usuario(UsuarioMapper.mapDtoToEntity(dto.get_usuario()));
        }

        return entity;
    }

    public static Usuario_VictimaDto mapEntityToDto(Usuario_Victima entity) {
        final Usuario_VictimaDto dto = new Usuario_VictimaDto();


        dto.setId(entity.get_id());

        if (Objects.nonNull(entity.get_usuario()))
            dto.set_usuario(UsuarioMapper.mapEntityToDto(entity.get_usuario()));

        return dto;
    }

    public static Usuario_Victima mapDtoToEntity(long id) {
        Usuario_Victima entity = EntityFactory.createUsuario_Victima(id);
        entity.set_id(id);
        return entity;
    }

    public static List<Usuario_VictimaDto> mapEntityListToDtoList(List<Usuario_Victima> entityList) {
        List<Usuario_VictimaDto> dtoList = new ArrayList<>();
        Usuario_VictimaDto usuarioVictimaDto;

        for (Usuario_Victima victimaUsuario : entityList) {
            usuarioVictimaDto = new Usuario_VictimaDto();
            usuarioVictimaDto.setId(victimaUsuario.get_id());

            if (Objects.nonNull(victimaUsuario.get_usuario()))
                usuarioVictimaDto.set_usuario(UsuarioMapper.mapEntityToDto(victimaUsuario.get_usuario()));

            dtoList.add(usuarioVictimaDto);
        }

        return dtoList;
    }
}