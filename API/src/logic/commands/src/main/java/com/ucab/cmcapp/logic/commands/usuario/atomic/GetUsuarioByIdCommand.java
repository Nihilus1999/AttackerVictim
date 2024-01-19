package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByIdCommand extends Command<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioByIdCommand.class);
    private long _userId;
    private Usuario _result;
    private UsuarioDao _dao;

    public GetUsuarioByIdCommand(DBHandler handler, long userId) {

        _logger.debug(String.format("Tomando GetUsuarioByIdCommand.ctor: parameter {%s}", userId));

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        _logger.debug(String.format("Dejando GetUsuarioByIdCommand.ctor: attribute {%s}", userId));

    }

    @Override
    public void execute() {

        _logger.debug("Tomando de GetUsuarioByIdCommand.execute");

        try{
            _result = _dao.find(_userId, Usuario.class);
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando GetUsuarioByIdCommand.execute");
    }

    @Override
    public Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(UsuarioDao usuarioDao) {

    }
}
