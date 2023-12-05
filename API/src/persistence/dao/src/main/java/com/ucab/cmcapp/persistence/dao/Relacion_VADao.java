package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


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
}
