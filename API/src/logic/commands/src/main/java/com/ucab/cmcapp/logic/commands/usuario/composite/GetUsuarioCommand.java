package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioCommand extends Command<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioCommand.class);
    private Usuario _usuario;
    long _id;

    public GetUsuarioCommand(Usuario usuario) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));
        _id = usuario.get_id();
        _usuario = usuario;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUsuarioCommand.ctor: attribute {%s}",
                _usuario.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetUsuarioByIdCommand getUsuarioByIdCommand = CommandFactory.createGetUsuarioByIdCommand(getHandler(), _id);
            getUsuarioByIdCommand.execute();
            _usuario = getUsuarioByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario getReturnParam() {
        return _usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetUsuarioByIdCommand(GetUsuarioByIdCommand getUsuarioByIdCommand) {

    }
}
