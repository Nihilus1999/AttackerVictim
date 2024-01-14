package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.AddAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAdministradorCommand extends Command<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(CreateAdministradorCommand.class);
    private Administrador _Administrador;
    private Administrador _result;
    private AddAdministradorCommand _addAdministradorCommand;

    public CreateAdministradorCommand(Administrador Administrador) {

        _logger.debug("Entrando en CreateAdministradorCommand.ctor");

        _Administrador = Administrador;
        setHandler(new DBHandler());

        _logger.debug("Dejando CreateAdministradorCommand.ctor");
    }

    @Override
    public void execute() {

        _logger.debug("Entrando CreateAdministradorCommand.execute");

        try {
            getHandler().beginTransaction();
            _addAdministradorCommand = CommandFactory.createAddAdministradorCommand(_Administrador, getHandler());
            _addAdministradorCommand.execute();
            _result = _addAdministradorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Dejando de  CreateAdministradorCommand.execute");
    }

    @Override
    public Administrador getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
