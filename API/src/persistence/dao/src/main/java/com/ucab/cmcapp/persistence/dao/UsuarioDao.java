package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
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

    public Usuario getUserByCorreo(String correo) {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug(String.format("Get in UsuarioDao.getUserByEmail: parameter {%s}", correo));
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_correo"), correo));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error UsuarioDao.getUserByCorreo: No Result {%s}", e.getMessage()));
            return null;
        } catch (Exception e) {
            _logger.error(String.format("Error UsuarioDao.getUserByCorreo: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leavin UsuarioDao.getUserByCorreo: result {%s}", result));
        //endregion

        return result;
    }

    public Usuario getUserByAlias(String alias) {
        Usuario result = EntityFactory.createUsuario();
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_alias"), alias));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    public Usuario getUserByCedula(String cedula) {
        Usuario result = EntityFactory.createUsuario();
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_cedula"), cedula));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

    public Usuario getUserByMac(String mac) {
        Usuario result = EntityFactory.createUsuario();
        try {
            CriteriaQuery<Usuario> query = _builder.createQuery(Usuario.class);
            Root<Usuario> root = query.from(Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_direccion_mac"), mac));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return result;
    }

}
