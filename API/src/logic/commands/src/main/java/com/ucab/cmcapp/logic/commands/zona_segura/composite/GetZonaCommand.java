package com.ucab.cmcapp.logic.commands.zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaCommand extends Command<Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(GetZonaCommand.class);
    private Zona_Segura _Zona_Segura;
    long _id;

    public GetZonaCommand(Zona_Segura Zona_Segura) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetZona_SeguraCommand.ctor: parameter {%s}",
                Zona_Segura.toString()));
        _id = Zona_Segura.get_id();
        _Zona_Segura = Zona_Segura;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetZona_SeguraCommand.ctor: attribute {%s}",
                _Zona_Segura.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetZonaByIdCommand getZona_SeguraByIdCommand = CommandFactory.createGetZona_SeguraByIdCommand(getHandler(), _id);
            getZona_SeguraByIdCommand.execute();
            _Zona_Segura = getZona_SeguraByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Zona_Segura getReturnParam() {
        return _Zona_Segura;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
