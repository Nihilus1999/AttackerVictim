package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EraseAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private AdministradorDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(AddAdministradorCommand.class);

    public EraseAdministradorCommand(Administrador Administrador, DBHandler handler) {

        _logger.debug(String.format("Tomar de EraseAdministradorCommand.ctor: parameter {%s}",
                Administrador.toString()));

        setHandler(handler);
        _Administrador = Administrador;
        _dao = DaoFactory.createAdministradorDao(getHandler());

        _logger.debug(String.format("Dejando EraseAdministradorCommand.ctor: attribute {%s}",
                _Administrador.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  EraseAdministradorCommand.execute");

        try {
            _Administrador = _dao.delete(_Administrador);
        }catch(NullPointerException e){

        }
        _logger.debug("Dejando de  EraseAdministradorCommand.execute");
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
