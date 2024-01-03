package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.ModifyUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private Usuario _result;
    private ModifyUsuarioCommand _modifyUsuarioCommand;

    public UpdateUsuarioCommand(Usuario usuario) {
        _usuario = usuario;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyUsuarioCommand = CommandFactory.createModifyUsuarioCommand(_usuario, getHandler());
            _modifyUsuarioCommand.execute();
            _result = _modifyUsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setModifyUsuarioCommand(ModifyUsuarioCommand modifyUsuarioCommand) {

    }
}
