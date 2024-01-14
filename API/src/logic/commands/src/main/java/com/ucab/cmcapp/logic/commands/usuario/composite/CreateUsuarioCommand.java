package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUsuarioCommand extends Command<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(CreateUsuarioCommand.class);
    private Usuario _usuario;
    private Usuario _result;
    private AddUsuarioCommand _addUsuarioCommand;

    public CreateUsuarioCommand(Usuario usuario) {

        _logger.debug("Entrando CreateUsuarioCommand.ctor");

        _usuario = usuario;
        setHandler(new DBHandler());


        _logger.debug("Dejando CreateUsuarioCommand.ctor");
    }

    @Override
    public void execute() {
        _logger.debug("Entrando CreateUsuarioCommand.execute");

        try {
            getHandler().beginTransaction();
            _addUsuarioCommand = CommandFactory.createAddUsuarioCommand(_usuario, getHandler());
            _addUsuarioCommand.execute();
            _result = _addUsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando CreateUsuarioCommand.execute");
    }

    @Override
    public Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setAddUsuarioCommand(AddUsuarioCommand addUsuarioCommand) {

    }
}
