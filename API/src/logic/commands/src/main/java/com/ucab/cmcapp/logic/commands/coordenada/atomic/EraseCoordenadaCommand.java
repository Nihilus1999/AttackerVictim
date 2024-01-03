package com.ucab.cmcapp.logic.commands.coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;

public class EraseCoordenadaCommand extends Command<Coordenada> {

    private Coordenada _Coordenada;
    private CoordenadaDao _dao;

    public EraseCoordenadaCommand(Coordenada Coordenada, DBHandler handler) {
        setHandler(handler);
        _Coordenada = Coordenada;
        _dao = DaoFactory.createCoordenadaDao(getHandler());

    }

    @Override
    public void execute() {
        try {
            _Coordenada = _dao.delete(_Coordenada);
        }catch(NullPointerException e){

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

    public void setCoordenadaDao(CoordenadaDao coordenadaDao) {

    }
}
