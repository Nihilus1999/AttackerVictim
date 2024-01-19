package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetUsuarioByListCommand extends Command<Usuario> {

    private List<Usuario> _result;
    private UsuarioDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(GetAdministradorByListCommand.class);

    public GetUsuarioByListCommand(DBHandler handler) {


        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

    }

    @Override
    public void execute() {

        _logger.debug("Tomando de GetUsuarioByListCommand.execute");

        try {
            _result = _dao.findAll(Usuario.class);
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando GetUsuarioByListCommand.execute");


    }

    @Override
    public List <Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {

    }
}
