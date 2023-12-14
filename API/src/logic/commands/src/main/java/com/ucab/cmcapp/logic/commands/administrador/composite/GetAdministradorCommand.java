package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministradorCommand extends Command<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorCommand.class);
    private Administrador _Administrador;
    long _id;

    public GetAdministradorCommand(Administrador Administrador) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Tomar de GetAdministradorCommand.ctor: parameter {%s}",
                Administrador.toString()));
        _id = Administrador.get_id();
        _Administrador = Administrador;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Dejando GetAdministradorCommand.ctor: attribute {%s}",
                _Administrador.toString()));
        //endregion
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en GetAdministradorCommand.execute");

        try {
            GetAdministradorByIdCommand getAdministradorByIdCommand = CommandFactory.createGetAdministradorByIdCommand(getHandler(), _id);
            getAdministradorByIdCommand.execute();
            _Administrador = getAdministradorByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando el GetAdministradorCommand.execute");
    }

    @Override
    public Administrador getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
