package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAdministradorByAliasCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private AdministradorDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorByAliasCommand.class);

    public GetAdministradorByAliasCommand(Administrador Administrador) {
        try {
            _logger.debug(String.format("Tomar de GetAdministradorCommand.ctor: parameter {%s}",
                    Administrador.toString()));

            _Administrador = Administrador;
            setHandler(new DBHandler());
            _dao = DaoFactory.createAdministradorDao(getHandler());

            _logger.debug(String.format("Dejando de GetAdministradorCommand.ctor: parameter {%s}",
                    _Administrador.toString()));

        }catch(NoClassDefFoundError e){

        }
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  GetAdministradorCommand.execute");

        try{
            _Administrador = _dao.getAdministradorByAlias(_Administrador.get_alias());
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando de  GetAdministradorCommand.execute");
    }

    @Override
    public Administrador getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(AdministradorDao administradorDao) {
    }
}
