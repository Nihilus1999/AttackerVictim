package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UsuarioDao extends BaseDao<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public UsuarioDao() {
        super();
    }

    public UsuarioDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Devuelve un usuario apartir de un correo
     * @param correo variable de tipo String
     * @return retorna un usuario
     */

    public Usuario getUsuarioByCorreo(String correo) {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug(String.format("Tomando en UsuarioDao.getUserByCorreo: parameter {%s}", correo));
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_correo"), correo));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error UsuarioDao.getUsuarioByCorreo: No Result {%s}", e.getMessage()));
            return null;
        } catch (Exception e) {
            _logger.error(String.format("Error UsuarioDao.getUsuarioByCorreo: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando UsuarioDao.getUsuarioByCorreo: result {%s}", result));
        return result;
    }

    /**
     * Devuelve un usuario apartir de un alias
     * @param alias variable de tipo String
     * @return retorna un usuario
     */

    public Usuario getUsuarioByAlias(String alias) {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug(String.format("Tomando en UsuarioDao.getUserByAlias: parameter {%s}", alias));

        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_alias"), alias));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByAlias: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Alias de usuario no existente");
        } catch (Exception e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByAlias: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }

        _logger.debug(String.format("Dejando UsuarioDao.getUsuarioByAlias: result {%s}", result));

        return result;
    }

    /**
     * Devuelve un usuario apartir de una cedula
     * @param cedula variable de tipo String
     * @return retorna un usuario
     */

    public Usuario getUsuarioByCedula(String cedula) {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug(String.format("Tomando en UsuarioDao.getUserByCedula: parameter {%s}", cedula));
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_cedula"), cedula));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByCedula: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Cedula de usuario no existente");
        } catch (Exception e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByCedula: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }

        _logger.debug(String.format("Dejando UsuarioDao.getUsuarioByCedula: result {%s}", result));
        return result;
    }

    /**
     * Devuelve un usuario apartir de una mac
     * @param mac variable de tipo String
     * @return retorna un usuario
     */

    public Usuario getUsuarioByMac(String mac) {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug(String.format("Tomando en UsuarioDao.getUserByMac: parameter {%s}", mac));
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_direccion_mac"), mac));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByMac: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Mac de usuario no existente");
        } catch (Exception e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByMac: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }

        _logger.debug(String.format("Dejando UsuarioDao.getUsuarioByMac: result {%s}", result));
        return result;
    }

}
