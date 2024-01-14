package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.EraseUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private Usuario _result;

    private static Logger _logger = LoggerFactory.getLogger(DeleteUsuarioCommand.class);

    private EraseUsuarioCommand _eraseUsuarioCommand;

    public DeleteUsuarioCommand(Usuario usuario) {

        _logger.debug("Entrando DeleteUsuarioCommand.ctor");

        _usuario = usuario;
        setHandler(new DBHandler());

        _logger.debug("Dejando DeleteUsuarioCommand.ctor");
    }

    @Override
    public void execute() {

        _logger.debug("Entrando DeleteUsuarioCommand.execute");
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

        _logger.debug("Dejando DeleteUsuarioCommand.execute");
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
