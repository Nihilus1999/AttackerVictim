package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Usuario;
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


public class Historico_UsuarioDao extends BaseDao<Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(Historico_UsuarioDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Historico_UsuarioDao() {
        super();
    }

    public Historico_UsuarioDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<Historico_Usuario> getAllHistoricoByUserId(Usuario userId) {
        List<Historico_Usuario> results;
        try {
            CriteriaQuery<Historico_Usuario> query = _builder.createQuery(Historico_Usuario.class);
            Root<Historico_Usuario> root = query.from(Historico_Usuario.class);

            query.select(root);
            query.where(_builder.equal(root.get("_usuario"), userId));

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
