package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class Usuario_AtacanteDao extends BaseDao<Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(Usuario_AtacanteDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public Usuario_AtacanteDao() {
        super();
    }

    public Usuario_AtacanteDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }
}
