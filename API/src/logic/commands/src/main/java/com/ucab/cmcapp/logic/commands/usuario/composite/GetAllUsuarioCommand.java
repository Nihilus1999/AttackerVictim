package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllUsuarioCommand extends Command <Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioCommand.class);
    private List<Usuario> _usuario;

    public GetAllUsuarioCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetUsuarioByListCommand getUsuarioByListCommand = CommandFactory.createGetUsuarioByListCommand(getHandler());
            getUsuarioByListCommand.execute();
            _usuario = getUsuarioByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Usuario> getReturnParam() {
        return _usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetUsuarioByListCommand(GetUsuarioByListCommand getUsuarioByListCommand) {

    }
}
