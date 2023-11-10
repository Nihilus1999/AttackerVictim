package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCorreoCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByAliasCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCedulaCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioService.class);

    @GET
    @Path("/{id}")
    public Response getUsuario(@PathParam("id") long userId) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        GetUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
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
        List <UsuarioDto> responseDTO = null;
        GetAllUsuarioCommand command = null;

        try {
            command = CommandFactory.createGetAllUsuarioCommand();
            command.execute();
            responseDTO = UsuarioMapper.mapEntityListToDtoList(command.getReturnParam());

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


    @GET
    @Path("correo/{correo}")
    public Response getUsuarioByCorreo(@PathParam("correo") String correo) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        GetUsuarioByCorreoCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntityCorreo(correo);
            command = CommandFactory.createGetUsuarioByCorreoCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El correo " + correo + " no ha sido encontrado en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al obtener el correo: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL correo " + correo + " del usuario ha sido encontrado exitosamente")).build();
    }

    @GET
    @Path("alias/{alias}")
    public Response getUsuarioByAlias(@PathParam("alias") String alias) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        GetUsuarioByAliasCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntityAlias(alias);
            command = CommandFactory.createGetUsuarioByAliasCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El usuario con el alias " + alias + " no existen en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno en la ruta cedula: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "EL usuario con el alias " + alias + " ha sido encontrado exitosamente")).build();
    }

    @GET
    @Path("cedula/{cedula}")
    public Response getUsuarioByCedula(@PathParam("cedula") String cedula) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        GetUsuarioByCedulaCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntityCedula(cedula);
            command = CommandFactory.createGetUsuarioByCedulaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La cedula " + cedula + " no ha sido encontrada en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with username: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario con la cedula " + cedula + " ha sido encontrado exitosamente")).build();
    }

    @POST
    public Response addUsuario(UsuarioDto usuarioDto) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        CreateUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(usuarioDto);
            command = CommandFactory.createCreateUsuarioCommand(entity);
            command.execute();
            responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
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
        Usuario entity;
        UsuarioDto responseDTO = null;
        DeleteUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(userId);
            command = CommandFactory.createDeleteUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
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

    /*@DELETE
    @Path("alias/{alias}")
    public Response deleteUsuario2(@PathParam("alias") String alias) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        DeleteUsuarioCommand command = null;

        try {
            entity = UsuarioMapper.mapDtoToEntity(alias);
            command = CommandFactory.createDeleteUsuarioCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("Could not delete user")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User eliminated correctly")).build();
    }*/

    @PUT
    public Response updateUsuario(UsuarioDto usuarioDto) {
        Usuario entity;
        UsuarioDto responseDTO = null;
        UpdateUsuarioCommand command = null;
        try {
            entity = UsuarioMapper.mapDtoToEntity(usuarioDto);
            command = CommandFactory.createUpdateUsuarioCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar el usuario: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El usuario con el ID " + usuarioDto.getId() + " se actualizo correctamente")).build();
    }
}
