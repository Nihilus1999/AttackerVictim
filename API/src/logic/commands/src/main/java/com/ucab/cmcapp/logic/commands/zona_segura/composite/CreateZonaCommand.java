package com.ucab.cmcapp.logic.commands.zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.AddZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateZonaCommand extends Command<Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(CreateZonaCommand.class);
    private Zona_Segura _Zona_Segura;
    private Zona_Segura _result;
    private AddZonaCommand _addZona_SeguraCommand;

    public CreateZonaCommand(Zona_Segura Zona_Segura) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateZona_SeguraCommand.ctor");
        //endregion

        _Zona_Segura = Zona_Segura;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateZona_SeguraCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateZona_SeguraCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addZona_SeguraCommand = CommandFactory.createAddZona_SeguraCommand(_Zona_Segura, getHandler());
            _addZona_SeguraCommand.execute();
            _result = _addZona_SeguraCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateZona_SeguraCommand.execute");
        //endregion
    }

    @Override
    public Zona_Segura getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setAddZonaCommand(AddZonaCommand addZonaCommand) {

    }
}
