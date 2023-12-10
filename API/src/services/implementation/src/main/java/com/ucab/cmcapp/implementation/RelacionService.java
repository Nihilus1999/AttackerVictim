package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.*;
import com.ucab.cmcapp.logic.dtos.Relacion_VADto;
import com.ucab.cmcapp.logic.mappers.Relacion_VAMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/relacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelacionService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(RelacionService.class);

    @GET
    @Path("/{id}")
    public Response getRelacion(@PathParam("id") long relacionId) {
        Relacion_VA entity;
        Relacion_VADto responseDTO = null;
        GetRelacionCommand command = null;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionId);
            command = CommandFactory.createGetRelacion_VACommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Relacion_VAMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + relacionId + " de la relacion victima-atacante no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + relacionId + " de la relacion victima-atacante ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllRelacion() {
        List <Relacion_VADto> responseDTO = null;
        GetAllRelacionCommand command = null;

        try {
            command = CommandFactory.createGetAllRelacion_VACommand();
            command.execute();
            responseDTO = Relacion_VAMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todas las victimas: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las relaciones victima-atacante se han obtenida correctamente")).build();
    }

    @POST
    public Response addRelacion(Relacion_VADto relacionUsuarioDto) {
        Relacion_VA entity;
        Relacion_VADto responseDTO = null;
        CreateRelacionCommand command = null;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionUsuarioDto);
            command = CommandFactory.createCreateRelacion_VACommand(entity);
            command.execute();
            responseDTO = Relacion_VAMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una victima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La relacion victima-atacante ha sido creado correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRelacion(@PathParam("id") long relacionId) {
        Relacion_VA entity;
        Relacion_VADto responseDTO = null;
        DeleteRelacionCommand command = null;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionId);
            command = CommandFactory.createDeleteRelacion_VACommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Relacion_VAMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la relacion victima-atacante con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una relacion victima-atacante", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La relacion victima-atacante ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateRelacion(Relacion_VADto usuarioRelacionDto) {
        Relacion_VA entity;
        Relacion_VADto responseDTO = null;
        UpdateRelacionCommand command = null;
        try {
            entity = Relacion_VAMapper.mapDtoToEntity(usuarioRelacionDto);
            command = CommandFactory.createUpdateRelacion_VACommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Relacion_VAMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioRelacionDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la relacion victima-atacante: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La relacion victima-atacante con el ID " + usuarioRelacionDto.getId() + " se actualizo correctamente")).build();
    }
}
