package com.ucab.cmcapp.logic.commands.relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetRelacionByListCommand extends Command<Relacion_VA> {

    private List<Relacion_VA> _result;
    private Relacion_VADao _dao;

    private static Logger _logger = LoggerFactory.getLogger(GetRelacionByListCommand.class);


    public GetRelacionByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createRelacion_VADao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de GetRelacionByListCommand.execute");

        try {
            _result = _dao.findAll(Relacion_VA.class);
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando GetRelacionByListCommand.execute");
    }

    @Override
    public List <Relacion_VA> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Relacion_VADao relacionVADao) {

    }
}
