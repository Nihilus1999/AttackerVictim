package com.ucab.cmcapp.implementation;


import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByUsuarioIdCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.NotificacionDto;
import com.ucab.cmcapp.logic.mappers.NotificacionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notificacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificacionService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(NotificacionService.class);

    @GET
    @Path("/{id}")
    public Response getNotificacion(@PathParam("id") long NotificacionId) {
        Notificacion entity;
        NotificacionDto responseDTO = null;
        GetNotificacionCommand command = null;

        try {
            entity = NotificacionMapper.mapDtoToEntity(NotificacionId);
            command = CommandFactory.createGetNotificacionCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = NotificacionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + NotificacionId + " de la Notificacion no existe en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + NotificacionId + " de la Notificacion ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllNotificacion() {
        List <NotificacionDto> responseDTO = null;
        GetAllNotificacionCommand command = null;

        try {
            command = CommandFactory.createGetAllNotificacionCommand();
            command.execute();
            responseDTO = NotificacionMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.isEmpty()) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todas las Notificacions se han obtenido correctamente")).build();
    }

    @GET
    @Path("usuario/{usuario_id}")
    public Response getAllNotificacionByUsuarioId(@PathParam("usuario_id") long usuarioId) {
        Notificacion entity;
        List<NotificacionDto> responseDTO = null;
        GetNotificacionByUsuarioIdCommand command = null;

        try {
            entity = NotificacionMapper.mapDtoToEntityUsuarioId(usuarioId);
            command = CommandFactory.createGetNotificacionByUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = NotificacionMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay Notificacion asociado al ID " + usuarioId + " del usuario")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id usuario" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Notificacion del usuario con el ID " + usuarioId + " se han obtenido correctamente")).build();
    }

    @POST
    public Response addNotificacion(NotificacionDto NotificacionUsuarioDto) {
        Notificacion entity;
        NotificacionDto responseDTO = null;
        CreateNotificacionCommand command = null;

        try {
            entity = NotificacionMapper.mapDtoToEntity(NotificacionUsuarioDto);
            command = CommandFactory.createCreateNotificacionCommand(entity);
            command.execute();
            responseDTO = NotificacionMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una Notificacion", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Notificacion ha sido creado correctamente")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNotificacion(@PathParam("id") long NotificacionId) {
        Notificacion entity;
        NotificacionDto responseDTO = null;
        DeleteNotificacionCommand command = null;

        try {
            entity = NotificacionMapper.mapDtoToEntity(NotificacionId);
            command = CommandFactory.createDeleteNotificacionCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = NotificacionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el Notificacion con ese ID")).build();


        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La Notificacion ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateNotificacion(NotificacionDto NotificacionUsuarioDto) {
        Notificacion entity;
        NotificacionDto responseDTO = null;
        UpdateNotificacionCommand command = null;
        try {
            entity = NotificacionMapper.mapDtoToEntity(NotificacionUsuarioDto);
            command = CommandFactory.createUpdateNotificacionCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = NotificacionMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + NotificacionUsuarioDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el Notificacion: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Notificacion con el ID " + NotificacionUsuarioDto.getId() + " se actualizo correctamente")).build();
    }
}
