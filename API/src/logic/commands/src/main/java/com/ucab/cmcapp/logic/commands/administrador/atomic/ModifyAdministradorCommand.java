package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Null;

public class ModifyAdministradorCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private AdministradorDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(ModifyAdministradorCommand.class);

    public ModifyAdministradorCommand(Administrador Administrador, DBHandler handler) {

        _logger.debug(String.format("Tomar de ModifyAdministradorCommand.ctor: parameter {%s}",
                Administrador.toString()));
        try {
            setHandler(handler);
            _Administrador = Administrador;
            _dao = DaoFactory.createAdministradorDao(getHandler());
        }catch(NoClassDefFoundError e){

        }catch(NullPointerException e){

        }

        _logger.debug(String.format("Dejando ModifyAdministradorCommand.ctor: attribute {%s}",
                _Administrador.toString()));
    }

    @Override
    public void execute() {
        try{
            _logger.debug("Tomando de ModifyAdministradorCommand.execute");

            _Administrador = _dao.update(_Administrador);
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando en ModifyAdministradorCommand.execute");

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
