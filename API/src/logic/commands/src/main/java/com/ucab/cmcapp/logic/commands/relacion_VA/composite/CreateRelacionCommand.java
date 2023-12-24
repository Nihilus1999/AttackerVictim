package com.ucab.cmcapp.logic.commands.relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.AddRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateRelacionCommand extends Command<Relacion_VA> {
    private static Logger _logger = LoggerFactory.getLogger(CreateRelacionCommand.class);
    private Relacion_VA _Relacion_VA;
    private Relacion_VA _result;
    private AddRelacionCommand _addRelacion_VACommand;

    public CreateRelacionCommand(Relacion_VA Relacion_VA) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateRelacion_VACommand.ctor");
        //endregion

        _Relacion_VA = Relacion_VA;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateRelacion_VACommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateRelacion_VACommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addRelacion_VACommand = CommandFactory.createAddRelacion_VACommand(_Relacion_VA, getHandler());
            _addRelacion_VACommand.execute();
            _result = _addRelacion_VACommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateRelacion_VACommand.execute");
        //endregion
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
