package com.ucab.cmcapp.logic.commands.relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRelacionCommand extends Command<Relacion_VA> {
    private static Logger _logger = LoggerFactory.getLogger(GetRelacionCommand.class);
    private Relacion_VA _Relacion_VA;
    long _id;

    public GetRelacionCommand(Relacion_VA Relacion_VA) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetRelacion_VACommand.ctor: parameter {%s}",
                Relacion_VA.toString()));
        _id = Relacion_VA.get_id();
        _Relacion_VA = Relacion_VA;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetRelacion_VACommand.ctor: attribute {%s}",
                _Relacion_VA.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetRelacionByIdCommand getRelacion_VAByIdCommand = CommandFactory.createGetRelacion_VAByIdCommand(getHandler(), _id);
            getRelacion_VAByIdCommand.execute();
            _Relacion_VA = getRelacion_VAByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Relacion_VA getReturnParam() {
        return _Relacion_VA;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
