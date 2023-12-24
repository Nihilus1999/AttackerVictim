package com.ucab.cmcapp.logic.commands.coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordenadaCommand extends Command<Coordenada> {
    private static Logger _logger = LoggerFactory.getLogger(GetCoordenadaCommand.class);
    private Coordenada _Coordenada;
    long _id;

    public GetCoordenadaCommand(Coordenada Coordenada) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetCoordenadaCommand.ctor: parameter {%s}",
                Coordenada.toString()));
        _id = Coordenada.get_id();
        _Coordenada = Coordenada;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetCoordenadaCommand.ctor: attribute {%s}",
                _Coordenada.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetCoordenadaByIdCommand getCoordenadaByIdCommand = CommandFactory.createGetCoordenadaByIdCommand(getHandler(), _id);
            getCoordenadaByIdCommand.execute();
            _Coordenada = getCoordenadaByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Coordenada getReturnParam() {
        return _Coordenada;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
