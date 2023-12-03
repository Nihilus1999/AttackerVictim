package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.*;
import com.ucab.cmcapp.logic.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import com.ucab.cmcapp.logic.mappers.Historico_UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/historico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(HistoricoService.class);

    @GET
    @Path("/{id}")
    public Response getHistorico(@PathParam("id") long historicoId) {
        Historico_Usuario entity;
        Historico_UsuarioDto responseDTO = null;
        GetHistoricoCommand command = null;

        try {
            entity = Historico_UsuarioMapper.mapDtoToEntity(historicoId);
            command = CommandFactory.createGetHistorico_UsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + historicoId + " del historico no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + historicoId + " del historico ha sido encontrado correctamente")).build();
    }

    @GET
    @Path("/todos")
    public Response getAllHistorico() {
        List <Historico_UsuarioDto> responseDTO = null;
        GetAllHistoricoCommand command = null;

        try {
            command = CommandFactory.createGetAllHistorico_UsuarioCommand();
            command.execute();
            responseDTO = Historico_UsuarioMapper.mapEntityListToDtoList(command.getReturnParam());

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
    public Response addHistorico(Historico_UsuarioDto historicoUsuarioDto) {
        Historico_Usuario entity;
        Historico_UsuarioDto responseDTO = null;
        CreateHistoricoCommand command = null;

        try {
            entity = Historico_UsuarioMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createCreateHistorico_UsuarioCommand(entity);
            command.execute();
            responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
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
    public Response deleteHistorico(@PathParam("id") long historicoId) {
        Historico_Usuario entity;
        Historico_UsuarioDto responseDTO = null;
        DeleteHistoricoCommand command = null;

        try {
            entity = Historico_UsuarioMapper.mapDtoToEntity(historicoId);
            command = CommandFactory.createDeleteHistorico_UsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el historico con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un usuario", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El historico ha sido eliminado correctamente")).build();
    }

    @PUT
    public Response updateHistorico(Historico_UsuarioDto historicoUsuarioDto) {
        Historico_Usuario entity;
        Historico_UsuarioDto responseDTO = null;
        UpdateHistoricoCommand command = null;
        try {
            entity = Historico_UsuarioMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createUpdateHistorico_UsuarioCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + historicoUsuarioDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el historico: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El historico con el ID " + historicoUsuarioDto.getId() + " se actualizo correctamente")).build();
    }
}
