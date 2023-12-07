package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
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


public class Zona_SeguraDao extends BaseDao<Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(Zona_SeguraDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Zona_SeguraDao() {
        super();
    }

    public Zona_SeguraDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Zona_Segura> getZonaByUsuarioId(Usuario usuarioId) {
        List<Zona_Segura> results;
        try {
            CriteriaQuery<Zona_Segura> query = _builder.createQuery(Zona_Segura.class);
            Root<Zona_Segura> root = query.from(Zona_Segura.class);

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
