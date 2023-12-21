package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.exceptions.CupraException;
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

    public List<Historico_Usuario> getPosicionByRelacionId(Relacion_VA relacionId) {
        List<Historico_Usuario> results;
        try {
            //CriteriaQuery<Incident> query = _builder.createQuery(Incident.class);
            //Root<Incident> root = query.from(Incident.class);

            String customSql = "SELECT hu.* FROM historico_usuario hu INNER JOIN ((SELECT MAX(hu.id) AS ultimo_registro, 'usuario_victima' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_victima WHERE rva.id = 1 GROUP BY entidad) UNION (SELECT MAX(hu.id) AS ultimo_registro, 'usuario_atacante' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = 1 GROUP BY entidad)) ult ON hu.id = ult.ultimo_registro;\n";
            Query query = _em.createNativeQuery(customSql, Historico_Usuario.class);

            results = query.getResultList();

            if (results.size() < 2) // Retornar null en lugar de []
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
