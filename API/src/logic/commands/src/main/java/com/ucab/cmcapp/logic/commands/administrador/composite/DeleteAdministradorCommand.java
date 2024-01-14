package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.EraseAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private Administrador _result;

    private static Logger _logger = LoggerFactory.getLogger(CreateAdministradorCommand.class);

    private EraseAdministradorCommand _eraseAdministradorCommand;

    public DeleteAdministradorCommand(Administrador Administrador) {



        _logger.debug("Entrando en DeleteAdministradorCommand.ctor");

        _Administrador = Administrador;
        setHandler(new DBHandler());

        _logger.debug("Dejando en DeleteAdministradorCommand.ctor");
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en DeleteAdministradorCommand.execute");

        try {
            getHandler().beginTransaction();
            _eraseAdministradorCommand = CommandFactory.createEraseAdministradorCommand(_Administrador, getHandler());
            _eraseAdministradorCommand.execute();
            _result = _eraseAdministradorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando en DeleteAdministradorCommand.execute");
    }

    @Override
    public Administrador getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setEraseAdministradorCommand(EraseAdministradorCommand eraseAdministradorCommand) {

    }
}
