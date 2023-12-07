package com.ucab.cmcapp.logic.commands.coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;

import java.util.List;

public class GetCoordenadaByZonaIdCommand extends Command<Zona_Segura> {

    private Coordenada _coordenada;
    private List<Coordenada> _result;
    private CoordenadaDao _dao;

    public GetCoordenadaByZonaIdCommand(Coordenada coordenada) {
        _coordenada = coordenada;
        setHandler(new DBHandler());
        _dao = DaoFactory.createCoordenadaDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getCoordenadaByZonaId(_coordenada.get_zona_segura());
    }

    @Override
    public List<Coordenada> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
