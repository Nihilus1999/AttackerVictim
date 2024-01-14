package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.NotFoundException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public class Relacion_VADao extends BaseDao<Relacion_VA> {
    private static Logger _logger = LoggerFactory.getLogger(Relacion_VADao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Relacion_VADao() {
        super();
    }

    public Relacion_VADao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    /**
     * Devuelve una lista de historico donde se ve la ultima posicion de la victima y el atacante apartir del id de relacion_va
     * @param relacionId variable entera donde se coloca el id de relacion_va
     * @return retorna una lista de la ultima posicion de victima y atacante
     */
    public List<Historico_Usuario> getPosicionByRelacionId(Relacion_VA relacionId) {
        List<Historico_Usuario> results;
        _logger.debug(String.format("tomando de RelacionDao.getPosicionByrelacionId: parametro {%s}", relacionId));

        try {
            String customSql = "SELECT hu.* FROM historico_usuario hu INNER JOIN ((SELECT MAX(hu.id) AS ultimo_registro, 'usuario_victima' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_victima WHERE rva.id = "+ relacionId.get_id() + " GROUP BY entidad) UNION (SELECT MAX(hu.id) AS ultimo_registro, 'usuario_atacante' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = "+ relacionId.get_id() + " GROUP BY entidad)) ult ON hu.id = ult.ultimo_registro;";
            Query query = _em.createNativeQuery(customSql, Historico_Usuario.class);

            results = query.getResultList();

            if (results.size() < 2)
                return null;

        } catch (NoResultException e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("el id de relacion no existe");
            
        } catch (Exception e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando RelacionDao.getPosicionByRelacionId: result {%s}", results));
        return results;
    }

    /**
     * Devuelve una lista de historico donde se ve la ultima posicion del atacante apartir del id de relacion_va
     * @param relacionId variable entera donde se coloca el id de relacion_va
     * @return retorna una lista de la ultima posicion del atacante
     */
    public Historico_Usuario getPosicionAtacanteByRelacionId(Relacion_VA relacionId) {
        List<Historico_Usuario> results;
        _logger.debug(String.format("tomando de RelacionDao.getPosicionAtacanteByrelacionId: parametro {%s}", relacionId));
        try {

            String customSql = "SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = "+ relacionId.get_id() +" ORDER BY hu.id DESC LIMIT 1;";

            Query query = _em.createNativeQuery(customSql, Historico_Usuario.class);

            results = query.getResultList();

            if (results.size() < 1)
                return null;

        } catch (NoResultException e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionAtacanteByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("el id de relacion no existe");

        } catch (Exception e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionAtacanteByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando RelacionDao.getPosicionAtacanteByRelacionId: result {%s}", results));

        return results.get(0);
    }

    /**
     * Devuelve una lista de historico donde se ve la ultima posicion de la victima apartir del id de relacion_va
     * @param relacionId variable entera donde se coloca el id de relacion_va
     * @return retorna una lista de la ultima posicion de victima
     */
    public Historico_Usuario getPosicionVictimaByRelacionId(Relacion_VA relacionId) {
        List<Historico_Usuario> results;
        _logger.debug(String.format("tomando de RelacionDao.getPosicionVictimaByrelacionId: parametro {%s}", relacionId));
        try {

            String customSql = "SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_victima WHERE rva.id = "+ relacionId.get_id() +" ORDER BY hu.id DESC LIMIT 1;";

            Query query = _em.createNativeQuery(customSql, Historico_Usuario.class);

            results = query.getResultList();

            if (results.size() < 1)
                return null;

        } catch (NoResultException e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionVictimaByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new NotFoundException("el id de relacion no existe");

        } catch (Exception e) {
            _logger.error( String.format( "Error RelacionDao.getPosicionVictimaByRelacionId: No Result {%s}", e.getMessage() ) );
            throw new CupraException(e.getMessage());
        }
        _logger.debug(String.format("Dejando RelacionDao.getPosicionVictimaByRelacionId: result {%s}", results));
        return results.get(0);
    }
}
