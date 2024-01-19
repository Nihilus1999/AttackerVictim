package com.ucab.cmcapp.logic.commands.relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByListCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.GetRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllRelacionCommand extends Command <Relacion_VA> {
    private static Logger _logger = LoggerFactory.getLogger(GetRelacionCommand.class);
    private List<Relacion_VA> _Relacion_VA;

    public GetAllRelacionCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetRelacionByListCommand getRelacion_VAByListCommand = CommandFactory.createGetRelacion_VAByListCommand(getHandler());
            getRelacion_VAByListCommand.execute();
            _Relacion_VA = getRelacion_VAByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Relacion_VA> getReturnParam() {
        return _Relacion_VA;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
