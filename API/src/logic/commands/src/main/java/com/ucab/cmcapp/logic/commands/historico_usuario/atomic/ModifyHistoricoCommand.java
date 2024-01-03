package com.ucab.cmcapp.logic.commands.historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;

public class ModifyHistoricoCommand extends Command<Historico_Usuario> {

    private Historico_Usuario _Historico_Usuario;
    private Historico_UsuarioDao _dao;

    public ModifyHistoricoCommand(Historico_Usuario Historico_Usuario, DBHandler handler) {
        setHandler(handler);
        _Historico_Usuario = Historico_Usuario;
        _dao = DaoFactory.createHistorico_UsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _Historico_Usuario = _dao.update(_Historico_Usuario);
        }catch(NullPointerException e){

        }
    }

    @Override
    public Historico_Usuario getReturnParam() {
        return _Historico_Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setHistoricoUsuarioDao(Historico_UsuarioDao historicoUsuarioDao) {

    }
}
