package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/coordenadas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordenadaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaService.class);

    @GET
    @Path("/{id}")
    public Response getCoordenada(@PathParam("id") long userId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        GetCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + userId + " de usuario no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + userId + " del usuario ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllUsuario() {
        List <CoordenadaDto> responseDTO = null;
        GetAllCoordenadaCommand command = null;

        try {
            command = CommandFactory.createGetAllCoordenadaCommand();
            command.execute();
            responseDTO = CoordenadaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Los usuarios se han obtenido correctamente")).build();
    }

    @POST
    public Response addUsuario(CoordenadaDto coordenadaDto) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        CreateCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaDto);
            command = CommandFactory.createCreateCoordenadaCommand(entity);
            command.execute();
            responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario ha sido creado correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") long userId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        DeleteCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(userId);
            command = CommandFactory.createDeleteCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el usuario con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateCoordenada(CoordenadaDto CoordenadaDto) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        UpdateCoordenadaCommand command = null;
        try {
            entity = CoordenadaMapper.mapDtoToEntity(CoordenadaDto);
            command = CommandFactory.createUpdateCoordenadaCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + CoordenadaDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el usuario: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario con el ID " + CoordenadaDto.getId() + " se actualizo correctamente")).build();
    }
}
