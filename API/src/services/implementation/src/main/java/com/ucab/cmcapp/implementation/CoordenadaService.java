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
    public Response getCoordenada(@PathParam("id") long coordenadaId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        GetCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaId);
            command = CommandFactory.createGetCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + coordenadaId + " de coordenada no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + coordenadaId + " de la coordenada ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllCoordenada() {
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

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Las coordenadas se han obtenido correctamente")).build();
    }

    @POST
    public Response addCoordenada(CoordenadaDto coordenadaDto) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        CreateCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaDto);
            command = CommandFactory.createCreateCoordenadaCommand(entity);
            command.execute();
            responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una coordenada", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada ha sido creado correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCoordenada(@PathParam("id") long coordenadaId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        DeleteCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaId);
            command = CommandFactory.createDeleteCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la coordenada con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear una coordenada", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada ha sido eliminado correctamente")).build();
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
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la coordenada: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada con el ID " + CoordenadaDto.getId() + " se actualizo correctamente")).build();
    }
}
