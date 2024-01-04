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
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetRelacion_VAByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createRelacion_VADao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetRelacion_VAByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetRelacion_VAByIdCommand.execute");
        //endregion
        try {
            _result = _dao.find(_userId, Relacion_VA.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetRelacion_VAByIdCommand.execute");
        //endregion
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
