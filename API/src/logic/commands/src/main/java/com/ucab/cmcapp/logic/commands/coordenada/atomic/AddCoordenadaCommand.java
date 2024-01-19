package com.ucab.cmcapp.logic.commands.coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddCoordenadaCommand extends Command<Coordenada> {
    private static Logger _logger = LoggerFactory.getLogger(AddCoordenadaCommand.class);
    private Coordenada _Coordenada;
    private CoordenadaDao _dao;

    public AddCoordenadaCommand(Coordenada Coordenada, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddCoordenadaCommand.ctor: parameter {%s}",
                Coordenada.toString()));
        setHandler(handler);
        _Coordenada = Coordenada;
        _dao = DaoFactory.createCoordenadaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddCoordenadaCommand.ctor: attribute {%s}",
                _Coordenada.toString()));
        //endregion
    }

    public AddCoordenadaCommand(Coordenada Coordenada) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddCoordenadaCommand.ctor: parameter {%s}",
                Coordenada.toString()));
        _Coordenada = Coordenada;
        setHandler(new DBHandler());
        _dao = DaoFactory.createCoordenadaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddCoordenadaCommand.ctor: attribute {%s}",
                _Coordenada.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddCoordenadaCommand.execute");
        //endregion
        try {
            _Coordenada = _dao.insert(_Coordenada);
        }catch(NullPointerException e){

        }

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddCoordenadaCommand.execute");
        //endregion
    }

    @Override
    public Coordenada getReturnParam() {
        return _Coordenada;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setCoordenadaDao(CoordenadaDao coordenadaDao) {

    }
}
