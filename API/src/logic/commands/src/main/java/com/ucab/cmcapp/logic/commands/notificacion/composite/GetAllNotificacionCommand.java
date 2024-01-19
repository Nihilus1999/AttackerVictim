package com.ucab.cmcapp.logic.commands.notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByListCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.GetNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllNotificacionCommand extends Command <Notificacion> {
    private static Logger _logger = LoggerFactory.getLogger(GetNotificacionCommand.class);
    private List<Notificacion> _Notificacion;

    public GetAllNotificacionCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetNotificacionByListCommand getNotificacionByListCommand = CommandFactory.createGetNotificacionByListCommand(getHandler());
            getNotificacionByListCommand.execute();
            _Notificacion = getNotificacionByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Notificacion> getReturnParam() {
        return _Notificacion;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetNotificacionByListCommand(GetNotificacionByListCommand getNotificacionByListCommand) {

    }
}
