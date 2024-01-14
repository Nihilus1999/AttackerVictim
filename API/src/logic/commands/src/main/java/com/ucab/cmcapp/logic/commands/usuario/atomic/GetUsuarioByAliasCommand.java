package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByAliasCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByAliasCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(GetUsuarioByAliasCommand.class);


    public GetUsuarioByAliasCommand(Usuario usuario) {
        _logger.debug(String.format("Tomar de GetAdministradorCommand.ctor: parameter {%s}",
                usuario.toString()));

        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        _logger.debug(String.format("Dejando de GetAdministradorCommand.ctor: parameter {%s}",
                _usuario.toString()));
    }

    @Override
    public void execute() {

        _logger.debug("Tomando de  GetUsuarioCommand.execute");

        try{
            _usuario = _dao.getUsuarioByAlias(_usuario.get_alias());
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
