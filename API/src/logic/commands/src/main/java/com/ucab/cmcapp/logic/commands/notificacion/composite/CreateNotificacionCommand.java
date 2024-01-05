package com.ucab.cmcapp.logic.commands.notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.AddNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateNotificacionCommand extends Command<Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(CreateNotificacionCommand.class);
    private Notificacion _Notificacion;
    private Notificacion _result;
    private AddNotificacionCommand _addNotificacionCommand;

    public CreateNotificacionCommand(Notificacion Notificacion) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateNotificacionCommand.ctor");
        //endregion

        _Notificacion = Notificacion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateNotificacionCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateNotificacionCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addNotificacionCommand = CommandFactory.createAddNotificacionCommand(_Notificacion, getHandler());
            _addNotificacionCommand.execute();
            _result = _addNotificacionCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateNotificacionCommand.execute");
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
    
}
