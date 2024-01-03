package com.ucab.cmcapp.logic.commands.historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.ModifyHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateHistoricoCommand extends Command<Historico_Usuario> {

    private Historico_Usuario _Historico_Usuario;
    private Historico_Usuario _result;
    private ModifyHistoricoCommand _modifyHistorico_UsuarioCommand;

    public UpdateHistoricoCommand(Historico_Usuario Historico_Usuario) {
        _Historico_Usuario = Historico_Usuario;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyHistorico_UsuarioCommand = CommandFactory.createModifyHistorico_UsuarioCommand(_Historico_Usuario, getHandler());
            _modifyHistorico_UsuarioCommand.execute();
            _result = _modifyHistorico_UsuarioCommand.getReturnParam();
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

    public void setModifyHistoricoCommand(ModifyHistoricoCommand modifyHistoricoCommand) {

    }
}
