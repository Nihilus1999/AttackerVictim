package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministradorByIdCommand extends Command<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorByIdCommand.class);
    private long _adminId;
    private Administrador _result;
    private AdministradorDao _dao;

    public GetAdministradorByIdCommand(DBHandler handler, long adminId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetAdministradorByIdCommand.ctor: parameter {%s}", adminId));
        //endregion

        _adminId = adminId;
        setHandler(handler);
        _dao = DaoFactory.createAdministradorDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetAdministradorByIdCommand.ctor: attribute {%s}", adminId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetAdministradorByIdCommand.execute");
        //endregion
        _result = _dao.find(_adminId, Administrador.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetAdministradorByIdCommand.execute");
        //endregion
    }

    @Override
    public Administrador getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
