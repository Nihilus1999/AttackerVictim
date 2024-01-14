package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.ModifyUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private Usuario _result;
    private ModifyUsuarioCommand _modifyUsuarioCommand;

    private static Logger _logger = LoggerFactory.getLogger(UpdateUsuarioCommand.class);

    public UpdateUsuarioCommand(Usuario usuario) {

        _logger.debug(String.format("Entrando UpdateUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));

        _usuario = usuario;
        setHandler(new DBHandler());

        _logger.debug(String.format("Dejando UpdateUsuarioCommand.ctor: attribute {%s}",
                _usuario.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Entrando UpdateUsuarioCommand.execute");

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

        _logger.debug("Dejando UpdateUsuarioCommand.execute");
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
