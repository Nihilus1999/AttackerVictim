package com.ucab.cmcapp.logic.commands.notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetNotificacionByIdCommand extends Command<Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(GetNotificacionByIdCommand.class);
    private long _userId;
    private Notificacion _result;
    private NotificacionDao _dao;

    public GetNotificacionByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetNotificacionByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createNotificacionDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetNotificacionByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetNotificacionByIdCommand.execute");
        //endregion
        try {
            _result = _dao.find(_userId, Notificacion.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetNotificacionByIdCommand.execute");
        //endregion
    }

    @Override
    public Notificacion getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(NotificacionDao notificacionDao) {

    }
}
