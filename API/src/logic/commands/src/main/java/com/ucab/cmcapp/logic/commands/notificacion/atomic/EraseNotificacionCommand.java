package com.ucab.cmcapp.logic.commands.notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;

public class EraseNotificacionCommand extends Command<Notificacion> {

    private Notificacion _Notificacion;
    private NotificacionDao _dao;

    public EraseNotificacionCommand(Notificacion Notificacion, DBHandler handler) {
        setHandler(handler);
        _Notificacion = Notificacion;
        _dao = DaoFactory.createNotificacionDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _Notificacion = _dao.delete(_Notificacion);
        }catch(NullPointerException e){
            
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

    public void setDao(NotificacionDao notificacionDao) {

    }
}
