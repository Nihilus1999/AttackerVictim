package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;

import java.util.List;

public class GetUsuarioByListCommand extends Command<Usuario> {

    private List<Usuario> _result;
    private UsuarioDao _dao;

    public GetUsuarioByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        try {
            _result = _dao.findAll(Usuario.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {

    }
}
