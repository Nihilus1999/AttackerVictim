package com.ucab.cmcapp.logic.commands.zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaByIdCommand extends Command<Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(GetZonaByIdCommand.class);
    private long _userId;
    private Zona_Segura _result;
    private Zona_SeguraDao _dao;

    public GetZonaByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetZona_SeguraByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createZona_SeguraDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetZona_SeguraByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetZona_SeguraByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Zona_Segura.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetZona_SeguraByIdCommand.execute");
        //endregion
    }

    @Override
    public Zona_Segura getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
