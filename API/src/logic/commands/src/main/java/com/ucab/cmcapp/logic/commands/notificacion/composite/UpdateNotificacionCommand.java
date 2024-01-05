package com.ucab.cmcapp.logic.commands.notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.ModifyNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateNotificacionCommand extends Command<Notificacion> {

    private Notificacion _Notificacion;
    private Notificacion _result;
    private ModifyNotificacionCommand _modifyNotificacionCommand;

    public UpdateNotificacionCommand(Notificacion Notificacion) {
        _Notificacion = Notificacion;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyNotificacionCommand = CommandFactory.createModifyNotificacionCommand(_Notificacion, getHandler());
            _modifyNotificacionCommand.execute();
            _result = _modifyNotificacionCommand.getReturnParam();
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
