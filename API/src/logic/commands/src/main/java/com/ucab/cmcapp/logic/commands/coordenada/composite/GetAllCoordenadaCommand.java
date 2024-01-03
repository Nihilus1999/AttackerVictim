package com.ucab.cmcapp.logic.commands.coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllCoordenadaCommand extends Command <Coordenada> {
    private static Logger _logger = LoggerFactory.getLogger(GetCoordenadaCommand.class);
    private List<Coordenada> _Coordenada;

    public GetAllCoordenadaCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetCoordenadaByListCommand getCoordenadaByListCommand = CommandFactory.createGetCoordenadaByListCommand(getHandler());
            getCoordenadaByListCommand.execute();
            _Coordenada = getCoordenadaByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Coordenada> getReturnParam() {
        return _Coordenada;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetCoordenadaByListCommand(GetCoordenadaByListCommand getCoordenadaByListCommand) {

    }
}
