package com.ucab.cmcapp.logic.commands.usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;

import java.util.List;

public class GetVictimaByListCommand extends Command<Usuario_Victima> {

    private List<Usuario_Victima> _result;
    private Usuario_VictimaDao _dao;

    public GetVictimaByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createUsuario_VictimaDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(Usuario_Victima.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Usuario_Victima> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
