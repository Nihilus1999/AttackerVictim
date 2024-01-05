package com.ucab.cmcapp.logic.commands.notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetNotificacionCommand extends Command<Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(GetNotificacionCommand.class);
    private Notificacion _Notificacion;
    long _id;

    public GetNotificacionCommand(Notificacion Notificacion) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetNotificacionCommand.ctor: parameter {%s}",
                Notificacion.toString()));
        _id = Notificacion.get_id();
        _Notificacion = Notificacion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetNotificacionCommand.ctor: attribute {%s}",
                _Notificacion.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetNotificacionByIdCommand getNotificacionByIdCommand = CommandFactory.createGetNotificacionByIdCommand(getHandler(), _id);
            getNotificacionByIdCommand.execute();
            _Notificacion = getNotificacionByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
