package com.ucab.cmcapp.logic.commands.historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;

import java.util.List;

public class GetHistoricoByListCommand extends Command<Historico_Usuario> {

    private List<Historico_Usuario> _result;
    private Historico_UsuarioDao _dao;

    public GetHistoricoByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createHistorico_UsuarioDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        try {
            _result = _dao.findAll(Historico_Usuario.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Historico_Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setHistoricoUsuarioDao(Historico_UsuarioDao historicoUsuarioDao) {

    }
}
