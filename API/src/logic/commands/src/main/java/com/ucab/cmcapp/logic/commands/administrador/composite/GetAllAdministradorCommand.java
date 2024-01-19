package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByListCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.GetAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllAdministradorCommand extends Command <Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(GetAllAdministradorCommand.class);
    private List<Administrador> _Administrador;

    public GetAllAdministradorCommand() {

        _logger.debug("Entrando GetAllAdministradorCommand.ctor");

        setHandler(new DBHandler());

        _logger.debug("Dejando GetAllAdministradorCommand.ctor");

    }

    @Override
    public void execute() {

        _logger.debug("Entrando en GetAllAdministradorCommand.execute");

        try {
            GetAdministradorByListCommand getAdministradorByListCommand = CommandFactory.createGetAdministradorByListCommand(getHandler());
            getAdministradorByListCommand.execute();
            _Administrador = getAdministradorByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando en GetAllAdministradorCommand.execute");
    }

    @Override
    public List <Administrador> getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetAdministradorByListCommand(GetAdministradorByListCommand getAdministradorByListCommand) {

    }
}
