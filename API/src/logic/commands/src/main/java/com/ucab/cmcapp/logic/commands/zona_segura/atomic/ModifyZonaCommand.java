package com.ucab.cmcapp.logic.commands.zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;

public class ModifyZonaCommand extends Command<Zona_Segura> {

    private Zona_Segura _Zona_Segura;
    private Zona_SeguraDao _dao;

    public ModifyZonaCommand(Zona_Segura Zona_Segura, DBHandler handler) {
        setHandler(handler);
        _Zona_Segura = Zona_Segura;
        _dao = DaoFactory.createZona_SeguraDao(getHandler());
    }

    @Override
    public void execute() {
        _Zona_Segura = _dao.update(_Zona_Segura);
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
