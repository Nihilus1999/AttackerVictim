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
        try {
            _logger.debug(String.format("Tomar de AddAdministradorCommand.ctor: parameter {%s}",
                    Administrador.toString()));
            setHandler(handler);
            _Administrador = Administrador;
            _dao = DaoFactory.createAdministradorDao(getHandler());

            _logger.debug(String.format("Dejando AddAdministradorCommand.ctor: attribute {%s}",
                    _Administrador.toString()));

        }catch(NoClassDefFoundError e){

        }
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Tomando de  AddAdministradorCommand.execute");
        //endregion
        try{
            _Administrador = _dao.insert(_Administrador);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Dejando de  AddAdministradorCommand.execute");
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

    public void setDao(AdministradorDao administradorDao) {

    }
}
