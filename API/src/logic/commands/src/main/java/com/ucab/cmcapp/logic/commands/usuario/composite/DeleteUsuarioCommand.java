package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.EraseUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private Usuario _result;

    private EraseUsuarioCommand _eraseUsuarioCommand;

    public DeleteUsuarioCommand(Usuario usuario) {
        _usuario = usuario;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseUsuarioCommand = CommandFactory.createEraseUsuarioCommand(_usuario, getHandler());
            _eraseUsuarioCommand.execute();
            _result = _eraseUsuarioCommand.getReturnParam();
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

    public void setEraseUsuarioCommand(EraseUsuarioCommand eraseUsuarioCommand) {

    }
}
