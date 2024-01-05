package com.ucab.cmcapp.logic.commands.notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.EraseNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteNotificacionCommand extends Command<Notificacion> {

    private Notificacion _Notificacion;
    private Notificacion _result;

    private EraseNotificacionCommand _eraseNotificacionCommand;

    public DeleteNotificacionCommand(Notificacion Notificacion) {
        _Notificacion = Notificacion;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseNotificacionCommand = CommandFactory.createEraseNotificacionCommand(_Notificacion, getHandler());
            _eraseNotificacionCommand.execute();
            _result = _eraseNotificacionCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
