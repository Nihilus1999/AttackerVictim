package com.ucab.cmcapp.logic.commands.zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddZonaCommand extends Command<Zona_Segura> {
    private static Logger _logger = LoggerFactory.getLogger(AddZonaCommand.class);
    private Zona_Segura _Zona_Segura;
    private Zona_SeguraDao _dao;

    public AddZonaCommand(Zona_Segura Zona_Segura, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddZona_SeguraCommand.ctor: parameter {%s}",
                Zona_Segura.toString()));
        setHandler(handler);
        _Zona_Segura = Zona_Segura;
        _dao = DaoFactory.createZona_SeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddZona_SeguraCommand.ctor: attribute {%s}",
                _Zona_Segura.toString()));
        //endregion
    }

    public AddZonaCommand(Zona_Segura Zona_Segura) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddZona_SeguraCommand.ctor: parameter {%s}",
                Zona_Segura.toString()));
        _Zona_Segura = Zona_Segura;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZona_SeguraDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddZona_SeguraCommand.ctor: attribute {%s}",
                _Zona_Segura.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddZona_SeguraCommand.execute");
        //endregion

        _Zona_Segura = _dao.insert(_Zona_Segura);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddZona_SeguraCommand.execute");
        //endregion
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
