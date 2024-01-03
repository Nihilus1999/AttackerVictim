package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.ModifyAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private Administrador _result;
    private ModifyAdministradorCommand _modifyAdministradorCommand;

    private static Logger _logger = LoggerFactory.getLogger(CreateAdministradorCommand.class);

    public UpdateAdministradorCommand(Administrador Administrador) {
        _Administrador = Administrador;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {

        _logger.debug("Entrando en UpdateAdministradorCommand.execute");

        try {
            getHandler().beginTransaction();
            _modifyAdministradorCommand = CommandFactory.createModifyAdministradorCommand(_Administrador, getHandler());
            _modifyAdministradorCommand.execute();
            _result = _modifyAdministradorCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

        _logger.debug("Entrando en UpdateAdministradorCommand.execute");
    }

    @Override
    public Administrador getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setModifyAdministradorCommand(ModifyAdministradorCommand modifyAdministradorCommand) {

    }
}
