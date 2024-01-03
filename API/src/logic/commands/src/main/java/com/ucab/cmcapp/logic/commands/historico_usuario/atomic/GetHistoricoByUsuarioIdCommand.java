package com.ucab.cmcapp.logic.commands.historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;

import java.util.List;

public class GetHistoricoByUsuarioIdCommand extends Command<Historico_Usuario> {

    private Historico_Usuario _historico;
    private List<Historico_Usuario> _result;
    private Historico_UsuarioDao _dao;

    public GetHistoricoByUsuarioIdCommand(Historico_Usuario zonaSegura) {
        _historico = zonaSegura;
        setHandler(new DBHandler());
        _dao = DaoFactory.createHistorico_UsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _result = _dao.getAllHistoricoByUserId(_historico.get_usuario());
        }catch(NullPointerException e){

        }
    }

    @Override
    public List<Historico_Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setHistoricoUsuarioDao(Historico_UsuarioDao historicoUsuarioDao) {

    }
}
