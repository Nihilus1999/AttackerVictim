package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


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
}
