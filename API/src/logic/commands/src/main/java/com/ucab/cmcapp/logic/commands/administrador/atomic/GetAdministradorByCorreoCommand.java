package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministradorByCorreoCommand extends Command<Administrador> {
    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorByCorreoCommand.class);
    private Administrador _Administrador;
    private AdministradorDao _dao;

    public GetAdministradorByCorreoCommand(Administrador Administrador) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUserByEmailCommand.ctor: parameter {%s}", Administrador.toString()));
        _Administrador = Administrador;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdministradorDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leavin GetUserByEmailCommand.ctor: atribute {%s}", _Administrador.toString()));
        //endregion
    }

    public GetAdministradorByCorreoCommand(Administrador Administrador, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUserByEmailCommand.ctor: parameter {%s}", Administrador.toString()));
        _Administrador = Administrador;
        setHandler(handler);
        _dao = DaoFactory.createAdministradorDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leavin GetUserByEmailCommand.ctor: atribute {%s}", _Administrador.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetUserByEmailCommand.execute");
        //endregion
        _Administrador = _dao.getAdministradorByCorreo(_Administrador.get_correo());
        //region Instrumentation DEBUG
        _logger.debug("Leavin  GetUserByEmailCommand.execute");
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
