package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario_AtacanteMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Usuario_AtacanteMapper.class);

    public static Usuario_Atacante mapDtoToEntity(Usuario_AtacanteDto dto) throws ParseException {
        Usuario_Atacante entity = EntityFactory.createUsuario_Atacante();

        entity.set_id(dto.getId());

        if (Objects.nonNull(dto.get_usuario())) {
            entity.set_usuario(UsuarioMapper.mapDtoToEntity(dto.get_usuario()));
        }

        return entity;
    }

    public static Usuario_AtacanteDto mapEntityToDto(Usuario_Atacante entity) {
        final Usuario_AtacanteDto dto = new Usuario_AtacanteDto();

        dto.setId(entity.get_id());

        if (Objects.nonNull(entity.get_usuario()))
            dto.set_usuario(UsuarioMapper.mapEntityToDto(entity.get_usuario()));

        return dto;
    }

    public static Usuario_Atacante mapDtoToEntity(long id) {
        Usuario_Atacante entity = EntityFactory.createUsuario_Atacante(id);
        entity.set_id(id);
        return entity;
    }

    public static List<Usuario_AtacanteDto> mapEntityListToDtoList(List<Usuario_Atacante> entityList) {
        List<Usuario_AtacanteDto> dtoList = new ArrayList<>();
        Usuario_AtacanteDto usuarioAtacanteDto;

        for (Usuario_Atacante atacanteUsuario : entityList) {
            usuarioAtacanteDto = new Usuario_AtacanteDto();
            usuarioAtacanteDto.setId(atacanteUsuario.get_id());

            if (Objects.nonNull(atacanteUsuario.get_usuario()))
                usuarioAtacanteDto.set_usuario(UsuarioMapper.mapEntityToDto(atacanteUsuario.get_usuario()));

            dtoList.add(usuarioAtacanteDto);
        }

        return dtoList;
    }
}