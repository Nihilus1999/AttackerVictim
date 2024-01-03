package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByCorreoCommand extends Command<Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioByCorreoCommand.class);
    private Usuario _usuario;
    private UsuarioDao _dao;

    public GetUsuarioByCorreoCommand(Usuario usuario) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUserByEmailCommand.ctor: parameter {%s}", usuario.toString()));
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leavin GetUserByEmailCommand.ctor: atribute {%s}", _usuario.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetUserByEmailCommand.execute");
        //endregion
        try{
            _usuario = _dao.getUsuarioByCorreo(_usuario.get_correo());
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Leavin  GetUserByEmailCommand.execute");
        //endregion
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
