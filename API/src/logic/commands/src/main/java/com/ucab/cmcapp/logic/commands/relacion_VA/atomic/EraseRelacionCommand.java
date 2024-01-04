package com.ucab.cmcapp.logic.commands.relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;

public class EraseRelacionCommand extends Command<Relacion_VA> {

    private Relacion_VA _Relacion_VA;
    private Relacion_VADao _dao;

    public EraseRelacionCommand(Relacion_VA Relacion_VA, DBHandler handler) {
        setHandler(handler);
        _Relacion_VA = Relacion_VA;
        _dao = DaoFactory.createRelacion_VADao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _Relacion_VA = _dao.delete(_Relacion_VA);
        }catch(NullPointerException e){

        }
    }

    @Override
    public Relacion_VA getReturnParam() {
        return _Relacion_VA;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Relacion_VADao relacionVADao) {

    }
}
