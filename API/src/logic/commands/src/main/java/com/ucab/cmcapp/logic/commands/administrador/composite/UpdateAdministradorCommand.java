package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.ModifyAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private Administrador _result;
    private ModifyAdministradorCommand _modifyAdministradorCommand;

    public UpdateAdministradorCommand(Administrador Administrador) {
        _Administrador = Administrador;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
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
