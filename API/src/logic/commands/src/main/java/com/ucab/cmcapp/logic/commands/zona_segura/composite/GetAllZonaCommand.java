package com.ucab.cmcapp.logic.commands.zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllZonaCommand extends Command <Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(GetZonaCommand.class);
    private List<Zona_Segura> _Zona_Segura;

    public GetAllZonaCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetZonaByListCommand getZona_SeguraByListCommand = CommandFactory.createGetZona_SeguraByListCommand(getHandler());
            getZona_SeguraByListCommand.execute();
            _Zona_Segura = getZona_SeguraByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Zona_Segura> getReturnParam() {
        return _Zona_Segura;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
