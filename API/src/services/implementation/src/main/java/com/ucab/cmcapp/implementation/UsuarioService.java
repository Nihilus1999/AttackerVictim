package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCorreoCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByAliasCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCedulaCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for id " + userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error getUser with id " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for id " + userId + " found correctly")).build();
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for email " + correo)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with email: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for email " + correo + " found correctly")).build();
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for username " + alias)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with username: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for username " + alias + " found correctly")).build();
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No user found for username " + cedula)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error getUser with username: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User for username " + cedula + " found correctly")).build();
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
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User created correctly")).build();
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("Could not delete user")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User eliminated correctly")).build();
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
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("Could not edit user with id: " + usuarioDto.getId())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Exception error in updateUser: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "User with id " + usuarioDto.getId() + " modified correctly")).build();
    }
}
