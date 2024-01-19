package com.ucab.cmcapp.logic.commands.coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordenadaByIdCommand extends Command<Coordenada> {
    private static Logger _logger = LoggerFactory.getLogger(GetCoordenadaByIdCommand.class);
    private long _userId;
    private Coordenada _result;
    private CoordenadaDao _dao;

    public GetCoordenadaByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetCoordenadaByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createCoordenadaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetCoordenadaByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetCoordenadaByIdCommand.execute");
        //endregion
        try {
            _result = _dao.find(_userId, Coordenada.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetCoordenadaByIdCommand.execute");
        //endregion
    }

    @Override
    public Coordenada getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setCoordenadaDao(CoordenadaDao coordenadaDao) {

    }
}
