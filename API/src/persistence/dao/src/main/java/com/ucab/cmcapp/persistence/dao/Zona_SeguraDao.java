package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.entities.Zona_Segura;
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

    /**
     * Devuelve una lista de zonas seguras apartir del id de usuario_victima
     * @param victimaId variable entera del id de victima
     * @return devuelve una lista de zonas seguras
     */

    public List<Zona_Segura> getZonaByVictimaId(Usuario_Victima victimaId) {
        List<Zona_Segura> results;
        _logger.debug(String.format("tomando de Zona_SeguraDao.getZonaByvictimaId: parametro {%s}", victimaId));
        try {
            CriteriaQuery<Zona_Segura> query = _builder.createQuery(Zona_Segura.class);
            Root<Zona_Segura> root = query.from(Zona_Segura.class);

            query.select(root);
            query.where(_builder.equal(root.get("_victima"), victimaId));

            results = _em.createQuery(query).getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            _logger.error( String.format( "Error Zona_SeguraDao.getZonaByVictimaId: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("Zona Segura del id victima no existe");
        } catch (Exception e) {
            _logger.error( String.format( "Error Zona_SeguraDao.getZonaByVictimaId: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando Zona_SeguraDao.getZonaByVictimaId: result {%s}", results));
        return results;
    }
}
