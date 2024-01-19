package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import com.ucab.cmcapp.logic.mappers.Usuario_AtacanteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/atacante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtacanteService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AtacanteService.class);

    /**
     * Obtiene un atacante por su ID.
     *
     * @param atacanteId el ID del atacante a obtener.
     * @return una respuesta HTTP con el atacante obtenido o un mensaje de error si no existe.
     */
    @GET
    @Path("/{id}")
    public Response getAtacante(@PathParam("id") long atacanteId) {
        Usuario_Atacante entity;
        Usuario_AtacanteDto responseDTO = null;
        GetAtacanteCommand command = null;

        try {
            entity = Usuario_AtacanteMapper.mapDtoToEntity(atacanteId);
            command = CommandFactory.createGetUsuario_AtacanteCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_AtacanteMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + atacanteId + " del atacante no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + atacanteId + " del atacante ha sido encontrado correctamente")).build();
    }

    /**
     * Obtiene todos los atacantes.
     *
     * @return una respuesta HTTP con la lista de atacantes o un mensaje de error si la base de datos está vacía.
     */
    @GET
    @Path("/todos")
    public Response getAllAtacante() {
        List<Usuario_AtacanteDto> responseDTO = null;
        GetAllAtacanteCommand command = null;

        try {
            command = CommandFactory.createGetAllUsuario_AtacanteCommand();
            command.execute();
            responseDTO = Usuario_AtacanteMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos está vacía ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos los atacantes se han obtenido correctamente")).build();
    }

    /**
     * Agrega un atacante.
     *
     * @param atacanteDto el DTO del atacante a agregar.
     * @return una respuesta HTTP con el atacante agregado o un mensaje de error si ocurre algún problema.
     */
    @POST
    public Response addAtacante(Usuario_AtacanteDto atacanteDto) {
        Usuario_Atacante entity;
        Usuario_AtacanteDto responseDTO = null;
        CreateAtacanteCommand command = null;

        try {
            entity = Usuario_AtacanteMapper.mapDtoToEntity(atacanteDto);
            command = CommandFactory.createCreateUsuario_AtacanteCommand(entity);
            command.execute();
            responseDTO = Usuario_AtacanteMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar un atacante", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO,"El atacante ha sido creado correctamente")).build();
    }

    /**
     * Elimina un atacante por su ID.
     *
     * @param atacanteId el ID del atacante a eliminar.
     * @return una respuesta HTTP con el atacante eliminado o un mensaje de error si no existe.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteAtacante(@PathParam("id") long atacanteId) {
        Usuario_Atacante entity;
        Usuario_AtacanteDto responseDTO = null;
        DeleteAtacanteCommand command = null;

        try {
            entity = Usuario_AtacanteMapper.mapDtoToEntity(atacanteId);
            command = CommandFactory.createDeleteUsuario_AtacanteCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_AtacanteMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el atacante con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar un atacante", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El atacante ha sido eliminado correctamente")).build();
    }

    /**
     * Actualiza un atacante.
     *
     * @param atacanteDto el DTO del atacante a actualizar.
     * @return una respuesta HTTP con el atacante actualizado o un mensaje de error si ocurre algún problema.
     */
    @PUT
    public Response updateAtacante(Usuario_AtacanteDto atacanteDto) {
        Usuario_Atacante entity;
        Usuario_AtacanteDto responseDTO = null;
        UpdateAtacanteCommand command = null;
        try {
            entity = Usuario_AtacanteMapper.mapDtoToEntity(atacanteDto);
            command = CommandFactory.createUpdateUsuario_AtacanteCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Usuario_AtacanteMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + atacanteDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el atacante: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El atacante con el ID " + atacanteDto.getId() + " se actualizó correctamente")).build();
    }
}