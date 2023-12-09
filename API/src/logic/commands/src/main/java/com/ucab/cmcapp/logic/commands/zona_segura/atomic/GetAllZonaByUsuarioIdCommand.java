package com.ucab.cmcapp.logic.commands.zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;

import java.util.List;

public class GetAllZonaByUsuarioIdCommand extends Command<Zona_Segura> {
    private Zona_Segura _safeZone;
    private List<Zona_Segura> _result;
    private Zona_SeguraDao _dao;

    public GetAllZonaByUsuarioIdCommand(Zona_Segura safeZone) {
        _safeZone = safeZone;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZona_SeguraDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getZonaByUsuarioId(_safeZone.get_usuario());
    }

    @Override
    public List<Zona_Segura> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
