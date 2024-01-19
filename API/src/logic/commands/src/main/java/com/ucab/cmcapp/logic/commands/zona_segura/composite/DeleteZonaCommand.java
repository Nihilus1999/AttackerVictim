package com.ucab.cmcapp.logic.commands.zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.EraseZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteZonaCommand extends Command<Zona_Segura> {

    private Zona_Segura _Zona_Segura;
    private Zona_Segura _result;

    private EraseZonaCommand _eraseZona_SeguraCommand;

    public DeleteZonaCommand(Zona_Segura Zona_Segura) {
        _Zona_Segura = Zona_Segura;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseZona_SeguraCommand = CommandFactory.createEraseZona_SeguraCommand(_Zona_Segura, getHandler());
            _eraseZona_SeguraCommand.execute();
            _result = _eraseZona_SeguraCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Zona_Segura getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setEraseZonaCommand(EraseZonaCommand eraseZonaCommand) {

    }
}
