package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class AdministradorDao extends BaseDao<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(AdministradorDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public AdministradorDao() {
        super();
    }

    public AdministradorDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Administrador getAdministradorByCorreo(String correo) {
        Administrador result = EntityFactory.createAdministrador();
        _logger.debug(String.format("Get in AdministradorDao.getUserByEmail: parameter {%s}", correo));
        try {
            CriteriaQuery<Administrador> query = _builder.createQuery(Administrador.class);
            Root<Administrador> root = query.from(Administrador.class);

            query.select(root);
            query.where(_builder.equal(root.get("_correo"), correo));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error AdministradorDao.getUserByCorreo: No Result {%s}", e.getMessage()));
            return null;
        } catch (Exception e) {
            _logger.error(String.format("Error AdministradorDao.getUserByCorreo: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leavin AdministradorDao.getUserByCorreo: result {%s}", result));
        //endregion

        return result;
    }

    public Administrador getAdministradorByAlias(String alias) {
        Administrador result = EntityFactory.createAdministrador();
        try {
            CriteriaQuery<Administrador> query = _builder.createQuery(Administrador.class);
            Root<Administrador> root = query.from(Administrador.class);

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

}