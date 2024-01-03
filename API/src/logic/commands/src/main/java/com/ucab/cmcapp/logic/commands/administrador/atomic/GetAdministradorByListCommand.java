package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAdministradorByListCommand extends Command<Administrador> {

    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorByIdCommand.class);

    private List<Administrador> _result;
    private AdministradorDao _dao;

    public GetAdministradorByListCommand(DBHandler handler) {
        try {
            setHandler(handler);
            _dao = DaoFactory.createAdministradorDao(getHandler());
        }catch(NoClassDefFoundError e){

        }
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Tomando de GetAdministradorByListCommand.execute");
        //endregion
        try {
            _result = _dao.findAll(Administrador.class);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Dejando GetAdministradorByListCommand.execute");
        //endregion
    }

    @Override
    public List <Administrador> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(AdministradorDao administradorDao) {

    }
}
