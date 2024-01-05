package com.ucab.cmcapp.logic.commands.operaciones.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;

import java.util.List;

public class GetPosicionByRelacionIDCommand extends Command<Relacion_VA> {

    private Relacion_VA _relacion_va;
    private List<Historico_Usuario> _result;
    private Relacion_VADao _dao;

    public GetPosicionByRelacionIDCommand(Relacion_VA relacion_va) {
        //region Instrumentation DEBUG
        //endregion

        _relacion_va = relacion_va;

        setHandler(new DBHandler());
        _dao = DaoFactory.createRelacion_VADao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        try {
            _result = _dao.getPosicionByRelacionId(_relacion_va);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Historico_Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Relacion_VADao relacionVADao) {

    }
}
