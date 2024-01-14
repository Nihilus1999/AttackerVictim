package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByAliasCommand;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByCorreoCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import com.ucab.cmcapp.logic.mappers.AdministradorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/administrador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdministradorService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AdministradorService.class);

    /**
     * Obtiene un objeto Administrador por su ID.
     *
     * @param adminId ID del Administrador a obtener.
     * @return Respuesta HTTP con el objeto AdministradorDto correspondiente al ID proporcionado.
     */
    @GET
    @Path("/{id}")
    public Response getAdministrador(@PathParam("id") long adminId) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        GetAdministradorCommand command = null;

        _logger.debug( "Tomando de AdministradorService.getAdministrador" );

        try {
            entity = AdministradorMapper.mapDtoToEntity(adminId);
            command = CommandFactory.createGetAdministradorCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + adminId + " de Administrador no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.getAdministrador" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + adminId + " del Administrador ha sido encontrado correctamente")).build();
    }

    /**
     * Obtiene todos los objetos Administrador.
     *
     * @return Respuesta HTTP con una lista de objetos AdministradorDto.
     */
    @GET
    @Path("/todos")
    public Response getAllAdministrador() {
        List <AdministradorDto> responseDTO = null;
        GetAllAdministradorCommand command = null;

        _logger.debug( "Tomando de AdministradorService.getAllAdministrador" );

        try {
            command = CommandFactory.createGetAllAdministradorCommand();
            command.execute();
            responseDTO = AdministradorMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.getAllAdministrador" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Los Administradores se han obtenido correctamente")).build();
    }

    /**
     * Obtiene un objeto Administrador por su correo electrónico.
     *
     * @param correo Correo electrónico del Administrador a obtener.
     * @return Respuesta HTTP con el objeto AdministradorDto correspondiente al correo proporcionado.
     */
    @GET
    @Path("correo/{correo}")
    public Response getAdministradorByCorreo(@PathParam("correo") String correo) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        GetAdministradorByCorreoCommand command = null;

        _logger.debug( "Tomando de AdministradorService.getAdministradorbyCorreo" );

        try {
            entity = AdministradorMapper.mapDtoToEntityCorreo(correo);
            command = CommandFactory.createGetAdministradorByCorreoCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El correo " + correo + " no ha sido encontrado en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al obtener el correo: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.getAdministradorbyCorreo" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL correo " + correo + " del Administrador ha sido encontrado exitosamente")).build();
    }

    /**
     * Obtiene un objeto Administrador por su alias.
     *
     * @param alias Alias del Administrador a obtener.
     * @return Respuesta HTTP con el objeto AdministradorDto correspondiente al alias proporcionado.
     */
    @GET
    @Path("alias/{alias}")
    public Response getAdministradorByAlias(@PathParam("alias") String alias) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        GetAdministradorByAliasCommand command = null;

        _logger.debug( "Tomando de AdministradorService.getAdministradorbyAlias" );

        try {
            entity = AdministradorMapper.mapDtoToEntityAlias(alias);
            command = CommandFactory.createGetAdministradorByAliasCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El Administrador con el alias " + alias + " no existen en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno en la ruta alias: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.getAdministradorbyAlias" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL Administrador con el alias " + alias + " ha sido encontrado exitosamente")).build();
    }

    /**
     * Agrega un nuevo Administrador.
     *
     * @param AdministradorDto Objeto AdministradorDto a agregar.
     * @return Respuesta HTTP con el objeto AdministradorDto creado.
     */
    @POST
    public Response addAdministrador(AdministradorDto AdministradorDto) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        CreateAdministradorCommand command = null;

        _logger.debug( "Tomando de AdministradorService.addAdministrador" );

        try {
            entity = AdministradorMapper.mapDtoToEntity(AdministradorDto);
            command = CommandFactory.createCreateAdministradorCommand(entity);
            command.execute();
            responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de crear un Administrador", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.addAdministrador" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Administrador ha sido creado correctamente")).build();
    }

    /**
     * Elimina un Administrador por su ID.
     *
     * @param adminId ID del Administrador a eliminar.
     * @return Respuesta HTTP con el objeto AdministradorDto eliminado.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteAdministrador(@PathParam("id") long adminId) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        DeleteAdministradorCommand command = null;

        _logger.debug( "Tomando de AdministradorService.deleteAdministrador" );

        try {
            entity = AdministradorMapper.mapDtoToEntity(adminId);
            command = CommandFactory.createDeleteAdministradorCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar el Administrador con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar un Administrador", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.deleteAdministrador" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Administrador ha sido eliminado correctamente")).build();
    }

    /**
     * Actualiza un Administrador existente.
     *
     * @param AdministradorDto Objeto AdministradorDto con los datos actualizados.
     * @return Respuesta HTTP con el objeto AdministradorDto actualizado.
     */
    @PUT
    public Response updateAdministrador(AdministradorDto AdministradorDto) {
        Administrador entity;
        AdministradorDto responseDTO = null;
        UpdateAdministradorCommand command = null;

        _logger.debug( "Tomando de AdministradorService.updateAdministrador" );

        try {
            entity = AdministradorMapper.mapDtoToEntity(AdministradorDto);
            command = CommandFactory.createUpdateAdministradorCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = AdministradorMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + AdministradorDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el Administrador: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando AdministradorService.updateAdministrador" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El Administrador con el ID " + AdministradorDto.getId() + " se actualizo correctamente")).build();
    }
}
