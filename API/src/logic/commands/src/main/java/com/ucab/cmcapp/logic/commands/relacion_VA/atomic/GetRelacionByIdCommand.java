package com.ucab.cmcapp.logic.commands.relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRelacionByIdCommand extends Command<Relacion_VA> {
    private static Logger _logger = LoggerFactory.getLogger(GetRelacionByIdCommand.class);
    private long _userId;
    private Relacion_VA _result;
    private Relacion_VADao _dao;

    public GetRelacionByIdCommand(DBHandler handler, long userId) {
        _logger.debug(String.format("Tomando GetRelacion_VAByIdCommand.ctor: parameter {%s}", userId));

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createRelacion_VADao(getHandler());

        _logger.debug(String.format("Dejando GetRelacion_VAByIdCommand.ctor: attribute {%s}", userId));
    }

    @Override
    public void execute() {
        _logger.debug("Tomando GetRelacion_VAByIdCommand.execute");
        try {
            _result = _dao.find(_userId, Relacion_VA.class);
        }catch(NullPointerException e){

        }
        _logger.debug("Dejando  GetRelacion_VAByIdCommand.execute");
    }

    @Override
    public Relacion_VA getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Relacion_VADao relacionVADao) {

    }
}
