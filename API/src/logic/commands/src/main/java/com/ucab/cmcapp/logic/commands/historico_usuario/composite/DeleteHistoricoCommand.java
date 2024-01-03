package com.ucab.cmcapp.logic.commands.historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.EraseHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteHistoricoCommand extends Command<Historico_Usuario> {

    private Historico_Usuario _Historico_Usuario;
    private Historico_Usuario _result;

    private EraseHistoricoCommand _eraseHistorico_UsuarioCommand;

    public DeleteHistoricoCommand(Historico_Usuario Historico_Usuario) {
        _Historico_Usuario = Historico_Usuario;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseHistorico_UsuarioCommand = CommandFactory.createEraseHistorico_UsuarioCommand(_Historico_Usuario, getHandler());
            _eraseHistorico_UsuarioCommand.execute();
            _result = _eraseHistorico_UsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Historico_Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setEraseHistoricoCommand(EraseHistoricoCommand eraseHistoricoCommand) {

    }
}
