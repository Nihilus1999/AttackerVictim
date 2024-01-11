package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import com.ucab.cmcapp.common.exceptions.JsonValidationException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByAliasCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByAliasCommand;
import com.ucab.cmcapp.logic.dtos.utilities.CredencialesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutenticacionService extends BaseService{

    private static Logger _logger = LoggerFactory.getLogger( AutenticacionService.class );

    @POST
    @Path("/administrador")
    public Response authenticateAdmin(CredencialesDto credentiales){
        GetAdministradorByAliasCommand command;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AutenticacionService.authenticate" );
        //endregion

        try {
            Administrador admin = new Administrador();
            admin.set_alias(credentiales.get_alias());
            command = CommandFactory.createGetAdministradorByAliasCommand(admin);
            command.execute();
            Administrador foundUser = command.getReturnParam();
            if(credentiales.get_clave().equals(foundUser.get_clave())){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(new ArrayList(),"La Autenticacion se ha hecho correctamente")).build();
            }else{
                throw new AuthenticationException("Contraseña incorrecta");
            }
        }catch (JsonValidationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (AuthenticationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (NotFoundException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (Exception e){
            _logger.error("error {} authenticating user {}: {}", e.getMessage(), credentiales.get_alias(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
    }

    @POST
    @Path("/usuario")
    public Response authenticateUsuario(CredencialesDto credenciales){
        GetUsuarioByAliasCommand command;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AutenticacionService.authenticate" );
        //endregion

        try {
            Usuario usuario = new Usuario();
            usuario.set_alias(credenciales.get_alias());
            command = CommandFactory.createGetUsuarioByAliasCommand(usuario);
            command.execute();
            Usuario foundUser = command.getReturnParam();
            if(credenciales.get_clave().equals(foundUser.get_clave())){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(new ArrayList(),"La autenticacion se ha hecho correctamente")).build();
            }else{
                throw new AuthenticationException("Contraseña incorrecta");
            }
        }catch (JsonValidationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (AuthenticationException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (NotFoundException e){
            _logger.error("Validation error: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Validation error: " + e.getMessage())
                    .build());
        }catch (Exception e){
            _logger.error("error {} authenticating user {}: {}", e.getMessage(), credenciales.get_alias(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
    }
}