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
    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorCommand.class);
    private List<Administrador> _Administrador;

    public GetAllAdministradorCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetAdministradorByListCommand getAdministradorByListCommand = CommandFactory.createGetAdministradorByListCommand(getHandler());
            getAdministradorByListCommand.execute();
            _Administrador = getAdministradorByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Administrador> getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
