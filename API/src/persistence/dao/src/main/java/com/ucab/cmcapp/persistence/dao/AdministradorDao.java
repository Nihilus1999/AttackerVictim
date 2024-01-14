package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Administrador;
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


public class AdministradorDao extends BaseDao<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(AdministradorDao.class);
    public EntityManager _em;
    public CriteriaBuilder _builder;


    public AdministradorDao() {
        super();
    }

    public AdministradorDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Devuelve un administrador a traves de un correo
     * @param correo variable de tipo String
     * @return retorna un adminstrador si lo encuentra
     */

    public Administrador getAdministradorByCorreo(String correo) {
        Administrador result = EntityFactory.createAdministrador();
        _logger.debug(String.format("tomando de AdministradorDao.getAdministradorByCorreo: parametro {%s}", correo));
        try {
            CriteriaQuery<Administrador> query = _builder.createQuery(Administrador.class);
            Root<Administrador> root = query.from(Administrador.class);

            query.select(root);
            query.where(_builder.equal(root.get("_correo"), correo));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error AdministradorDao.getAdministradorByCorreo: No Result {%s}", e.getMessage()));
            throw new NotFoundException("Correo Administrador no existe");
        } catch (Exception e) {
            _logger.error(String.format("Error AdministradorDao.getAdministradorByCorreo: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando AdministradorDao.getAdministradorByCorreo: result {%s}", result));

        return result;
    }

    /**
     * Devuelve un administrador a traves de un alias
     * @param alias variable de tipo String
     * @return retorna un adminstrador si lo encuentra
     */

    public Administrador getAdministradorByAlias(String alias) {
        Administrador result = EntityFactory.createAdministrador();
        _logger.debug(String.format("tomando de AdministradorDao.getUsuarioByAlias: parametro {%s}", alias));
        try {
            CriteriaQuery<Administrador> query = _builder.createQuery(Administrador.class);
            Root<Administrador> root = query.from(Administrador.class);

            query.select(root);
            query.where(_builder.equal(root.get("_alias"), alias));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByAlias: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Alias Administrador no existe");
        } catch (Exception e) {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByAlias: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando AdministradorDao.getAdministradorByAlias: result {%s}", result));

        return result;
    }

}
