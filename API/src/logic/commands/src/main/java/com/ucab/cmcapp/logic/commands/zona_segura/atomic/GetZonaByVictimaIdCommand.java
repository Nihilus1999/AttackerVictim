package com.ucab.cmcapp.logic.commands.zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;

import java.util.List;

public class GetZonaByVictimaIdCommand extends Command<Zona_Segura> {

    private Zona_Segura _zonaSegura;
    private List<Zona_Segura> _result;
    private Zona_SeguraDao _dao;

    public GetZonaByVictimaIdCommand(Zona_Segura safeZone) {
        _zonaSegura = safeZone;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZona_SeguraDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _result = _dao.getZonaByVictimaId(_zonaSegura.get_victima());
        }catch (NullPointerException e){

        }
    }

    @Override
    public List<Zona_Segura> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Zona_SeguraDao zonaSeguraDao) {

    }
}
