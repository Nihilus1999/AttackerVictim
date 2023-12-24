package com.ucab.cmcapp.logic.commands.relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.ModifyRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateRelacionCommand extends Command<Relacion_VA> {

    private Relacion_VA _Relacion_VA;
    private Relacion_VA _result;
    private ModifyRelacionCommand _modifyRelacion_VACommand;

    public UpdateRelacionCommand(Relacion_VA Relacion_VA) {
        _Relacion_VA = Relacion_VA;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyRelacion_VACommand = CommandFactory.createModifyRelacion_VACommand(_Relacion_VA, getHandler());
            _modifyRelacion_VACommand.execute();
            _result = _modifyRelacion_VACommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Relacion_VA getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
