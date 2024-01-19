package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Usuario;
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


public class CoordenadaDao extends BaseDao<Coordenada> {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public CoordenadaDao() {
        super();
    }

    public CoordenadaDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Este metodo devuelve una lista de zonas seguras
     * @param zonaId zonaId es el id de la zona segura
     * @return retorna todas las coordenadas de esa zona segura
     */

    public List<Coordenada> getCoordenadaByZonaId(Zona_Segura zonaId) {
        List<Coordenada> results;
        _logger.debug(String.format("tomando de CoordenadaDao.getCoordenadaByZona: parametro {%s}", zonaId));

        try {
            CriteriaQuery<Coordenada> query = _builder.createQuery(Coordenada.class);
            Root<Coordenada> root = query.from(Coordenada.class);

            query.select(root);
            query.where(_builder.equal(root.get("_zona_segura"), zonaId));

            results = _em.createQuery(query).getResultList();

            if (results.isEmpty()) // Retornar null en lugar de []
                return null;

        } catch (NoResultException e) {
            _logger.error(String.format("Error CoordenadaDao.getCoordenadaByZona: No Result {%s}", e.getMessage()));
            throw new NotFoundException("coordenada por zona no existe");
        } catch (Exception e) {
            _logger.error( String.format( "Error CoordenadaDao.getCoordenadaByZona: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }

        _logger.debug(String.format("Dejando UsuarioDao.getUsuarioByCorreo: result {%s}", results));
        return results;
    }

}
