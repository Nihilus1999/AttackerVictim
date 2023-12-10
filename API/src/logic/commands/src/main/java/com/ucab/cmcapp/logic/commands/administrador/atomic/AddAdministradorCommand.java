package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAdministradorCommand extends Command<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(AddAdministradorCommand.class);
    private Administrador _Administrador;
    private AdministradorDao _dao;

    public AddAdministradorCommand(Administrador Administrador, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddAdministradorCommand.ctor: parameter {%s}",
                Administrador.toString()));
        setHandler(handler);
        _Administrador = Administrador;
        _dao = DaoFactory.createAdministradorDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddAdministradorCommand.ctor: attribute {%s}",
                _Administrador.toString()));
        //endregion
    }

    public AddAdministradorCommand(Administrador Administrador) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddAdministradorCommand.ctor: parameter {%s}",
                Administrador.toString()));
        _Administrador = Administrador;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdministradorDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddAdministradorCommand.ctor: attribute {%s}",
                _Administrador.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddAdministradorCommand.execute");
        //endregion

        _Administrador = _dao.insert(_Administrador);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddAdministradorCommand.execute");
        //endregion
    }

    @Override
    public Administrador getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}