package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class NotificacionDao extends BaseDao<Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(NotificacionDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public NotificacionDao() {
        super();
    }

    public NotificacionDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Notificacion> getNotificacionByUsuarioId(Usuario usuarioId) {
        List<Notificacion> results;
        try {
            CriteriaQuery<Notificacion> query = _builder.createQuery(Notificacion.class);
            Root<Notificacion> root = query.from(Notificacion.class);

            query.select(root);
            query.where(_builder.equal(root.get("_usuario"), usuarioId));

            results = _em.createQuery(query).getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            //return Collections.emptyList();  // En caso de que quieras retornar []
            return null;
        } catch (Exception e) {
            throw new CupraException(e.getMessage());
        }

        return results;
    }

}