package com.ucab.cmcapp.persistence.dao;


import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class Usuario_VictimaDao extends BaseDao<Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(Usuario_VictimaDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Usuario_VictimaDao() {
        super();
    }

    public Usuario_VictimaDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
