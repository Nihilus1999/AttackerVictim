package com.ucab.cmcapp.logic.commands.notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;

import java.util.List;

public class GetNotificacionByUsuarioIdCommand extends Command<Notificacion> {

    private Notificacion _Notificacion;
    private List<Notificacion> _result;
    private NotificacionDao _dao;

    public GetNotificacionByUsuarioIdCommand(Notificacion zonaSegura) {
        _Notificacion = zonaSegura;
        setHandler(new DBHandler());
        _dao = DaoFactory.createNotificacionDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _result = _dao.getNotificacionByUsuarioId(_Notificacion.get_usuario());
        }catch(NullPointerException e){

        }
    }

    @Override
    public List<Notificacion> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
