package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.*;
import com.ucab.cmcapp.logic.dtos.Usuario_VictimaDto;
import com.ucab.cmcapp.logic.mappers.Usuario_VictimaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/victima")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VictimaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(VictimaService.class);

    @GET
    @Path("/{id}")
    public Response getVictima(@PathParam("id") long victimaId) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        GetVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(victimaId);
            command = CommandFactory.createGetUsuario_VictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + victimaId + " del historico no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + victimaId + " del historico ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllHistorico() {
        List <Usuario_VictimaDto> responseDTO = null;
        GetAllVictimaCommand command = null;

        try {
            command = CommandFactory.createGetAllUsuario_VictimaCommand();
            command.execute();
            responseDTO = Usuario_VictimaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos los historicos se han obtenido correctamente")).build();
    }

    @POST
    public Response addHistorico(Usuario_VictimaDto historicoUsuarioDto) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        CreateVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createCreateUsuario_VictimaCommand(entity);
            command.execute();
            responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar un historico", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El historico ha sido creado correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHistorico(@PathParam("id") long userId) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        DeleteVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(userId);
            command = CommandFactory.createDeleteUsuario_VictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el historico con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La historico ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateHistorico(Usuario_VictimaDto historicoUsuarioDto) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        UpdateVictimaCommand command = null;
        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createUpdateUsuario_VictimaCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + historicoUsuarioDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la coordenada: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El historico con el ID " + historicoUsuarioDto.getId() + " se actualizo correctamente")).build();
    }
}
