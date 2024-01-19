package com.ucab.cmcapp.logic.commands.notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;

import java.util.List;

public class GetNotificacionByListCommand extends Command<Notificacion> {

    private List<Notificacion> _result;
    private NotificacionDao _dao;

    public GetNotificacionByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createNotificacionDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        try {
            _result = _dao.findAll(Notificacion.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Notificacion> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(NotificacionDao notificacionDao) {
    }
}
