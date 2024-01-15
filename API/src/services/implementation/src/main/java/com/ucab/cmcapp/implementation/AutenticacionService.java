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
import com.ucab.cmcapp.logic.dtos.extras.LDAPAdministradorDto;
import com.ucab.cmcapp.logic.dtos.extras.CredencialesDto;
import com.ucab.cmcapp.logic.dtos.extras.LDAPUsuarioDto;
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

    private static Logger _logger = LoggerFactory.getLogger(AutenticacionService.class);

    /**
     * Autentica a un administrador utilizando las credenciales proporcionadas.
     *
     * @param credenciales Las credenciales de autenticación del administrador.
     * @return Un objeto de tipo Response con el resultado de la autenticación.
     */
    @POST
    @Path("/administrador")
    public Response autenticarAdministrador(CredencialesDto credenciales){

        _logger.debug( "Entrando en AutenticacionService.autenticarAdministrador" );
        GetAdministradorByAliasCommand command = null;
        try{
            Administrador administrador = new Administrador();
            administrador.set_alias(credenciales.get_alias());
            command = CommandFactory.createGetAdministradorByAliasCommand(administrador);
            command.execute();
            Administrador admin = command.getReturnParam();
            if(LDAPAdministradorDto.autenticarAdministrator(credenciales.get_alias(), credenciales.get_clave())){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(true, "El administrador ha ingresado correctamente")).build();
            } else {
                if(!credenciales.get_clave().equals(admin.get_clave())){
                    return Response.status(Response.Status.UNAUTHORIZED).entity(new CustomResponse<>(false, "La contraseña es invalida")).build();
                }
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(false, "El administrador no existe")).build();
            }
        }catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new CustomResponse<>(false, "El administrador no existe")).build();

        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al validar " + e.getMessage())).build();
        }
        finally {
            _logger.debug( "Dejando en AutenticacionService.autenticarAdministrador" );
            if (command != null)
                command.closeHandlerSession();
        }
    }

    /**
     * Autentica a un usuario utilizando las credenciales proporcionadas.
     *
     * @param credenciales Las credenciales de autenticación del usuario.
     * @return Un objeto de tipo Response con el resultado de la autenticación.
     */
    @POST
    @Path("/usuario")
    public Response autenticarUsuario(CredencialesDto credenciales){
        GetUsuarioByAliasCommand command = null;

        _logger.debug( "Entrando en AutenticacionService.autenticarUsuario" );
        try{
            Usuario usuario = new Usuario();
            usuario.set_alias(credenciales.get_alias());
            command = CommandFactory.createGetUsuarioByAliasCommand(usuario);
            command.execute();
            Usuario user = command.getReturnParam();
            if(LDAPUsuarioDto.autenticarUsuario(credenciales.get_alias(), credenciales.get_clave())){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(true, "El usuario ha ingresado correctamente")).build();
            } else {
                if(!credenciales.get_clave().equals(user.get_clave())){
                    return Response.status(Response.Status.UNAUTHORIZED).entity(new CustomResponse<>(false, "La contraseña es invalida")).build();
                }
                return Response.status(Response.Status.OK).entity(new CustomResponse<>(false, "El usuario no existe")).build();
            }
        }catch (NotFoundException e) {
            _logger.error("Validation error: {}", e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(new CustomResponse<>(false, "El usuario no existe")).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al validar " + e.getMessage())).build();
        }
        finally {
            _logger.debug( "Dejando en AutenticacionService.autenticarUsuario" );
            if (command != null)
                command.closeHandlerSession();
        }
    }

}