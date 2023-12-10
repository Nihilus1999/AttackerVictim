package com.ucab.cmcapp.logic.commands.administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.EraseAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private Administrador _result;

    private EraseAdministradorCommand _eraseAdministradorCommand;

    public DeleteAdministradorCommand(Administrador Administrador) {
        _Administrador = Administrador;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
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
