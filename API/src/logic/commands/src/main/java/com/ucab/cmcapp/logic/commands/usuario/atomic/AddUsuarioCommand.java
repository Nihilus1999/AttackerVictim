package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUsuarioCommand extends Command<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(AddUsuarioCommand.class);
    private Usuario _usuario;
    private UsuarioDao _dao;

    public AddUsuarioCommand(Usuario usuario, DBHandler handler) {
        _logger.debug(String.format("Get in AddUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));

        setHandler(handler);
        _usuario = usuario;
        _dao = DaoFactory.createUsuarioDao(getHandler());


        _logger.debug(String.format("Leaving AddUsuarioCommand.ctor: attribute {%s}",
                _usuario.toString()));
    }

    public AddUsuarioCommand(Usuario usuario) {

        _logger.debug(String.format("Get in AddUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        _logger.debug(String.format("Leaving AddUsuarioCommand.ctor: attribute {%s}",
                _usuario.toString()));
    }

    @Override
    public void execute() {
        _logger.debug("Get in  AddUsuarioCommand.execute");

        try {
            _usuario = _dao.insert(_usuario);
        }catch(NullPointerException e){

        }

        _logger.debug("Get in  AddUsuarioCommand.execute");
    }

    @Override
    public Usuario getReturnParam() {
        return _usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(UsuarioDao usuarioDao) {

    }
}
