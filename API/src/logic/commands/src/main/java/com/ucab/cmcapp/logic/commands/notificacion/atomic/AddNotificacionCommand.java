package com.ucab.cmcapp.logic.commands.notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddNotificacionCommand extends Command<Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(AddNotificacionCommand.class);
    private Notificacion _Notificacion;
    private NotificacionDao _dao;

    public AddNotificacionCommand(Notificacion Notificacion, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddNotificacionCommand.ctor: parameter {%s}",
                Notificacion.toString()));
        setHandler(handler);
        _Notificacion = Notificacion;
        _dao = DaoFactory.createNotificacionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddNotificacionCommand.ctor: attribute {%s}",
                _Notificacion.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddNotificacionCommand.execute");
        //endregion
        try {
            _Notificacion = _dao.insert(_Notificacion);
        }catch(NullPointerException e){

        }

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddNotificacionCommand.execute");
        //endregion
    }

    @Override
    public Notificacion getReturnParam() {
        return _Notificacion;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
