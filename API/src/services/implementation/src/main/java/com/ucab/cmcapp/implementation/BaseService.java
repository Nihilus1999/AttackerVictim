package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.common.util.JWT;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/")
public class BaseService extends Application {
    private static Logger _logger = LoggerFactory.getLogger(BaseService.class);

    @Override
    public Set<Class<?>> getClasses() {
        final HashSet hash = new HashSet<Class<?>>();
        return hash;
    }

    /**
     * Metodo que valida que el parametro proveido al servicio no sea nulo
     *
     * @param object parametro que fue enviado al servicio
     */
    public void verifyParams(Object object) {
        if (object == null)
            throwException(Response.Status.BAD_REQUEST);
    }

    /**
     * Metodo para enviar un exceiption unicamente con el estado
     *
     * @param status estado HTTP de error a informar
     */
    public void throwException(Response.Status status) {
        throw new WebApplicationException(Response.status(status).build());
    }

    /**
     * Metodo para enviar exceptions personalizadas al usuario
     *
     * @param status estado HTTP de error a  informar
     * @param e      Exception a mostrar
     */
    public void throwException(Exception e, Response.Status status) {
        _logger.error(e.getMessage(), e);
        throw new WebApplicationException(Response.status(status).entity(e).build());
    }

    /**
     * Method for JWT validation
     *
     * @param credential JWT provided by the user
     */
    public UsuarioDto validateCredentials(String credential) {
        UsuarioDto user = null;
        try {
            user = JWT.verifyToken(credential);
            // region Instrumentation DEBUG
            _logger.debug("Authenticating User id: {}", user);
            // endregion
        } catch (JWTVerifyException e) {
            _logger.error(e.getMessage(), e);
            throw e;
        }
        return user;
    }
}
