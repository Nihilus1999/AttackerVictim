package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByCedulaCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioByCedulaCommand.class);

    public GetUsuarioByCedulaCommand(Usuario usuario) {

        _logger.debug(String.format("Tomar de GetUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));

        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        _logger.debug(String.format("Dejando de GetUsuarioCommand.ctor: parameter {%s}",
                _usuario.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  GetUsuarioCommand.execute");

        try {
            _usuario = _dao.getUsuarioByCedula(_usuario.get_cedula());
        }catch(NullPointerException e){

        }

        _logger.debug("Dejando de  GetUsuarioCommand.execute");
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
