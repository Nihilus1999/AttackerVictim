package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.administrador.atomic.ModifyAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModifyUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    private static Logger _logger = LoggerFactory.getLogger(ModifyAdministradorCommand.class);

    public ModifyUsuarioCommand(Usuario usuario, DBHandler handler) {

        _logger.debug(String.format("Tomar de ModifyUsuarioCommand.ctor: parameter {%s}",
                usuario.toString()));

        setHandler(handler);
        _usuario = usuario;
        _dao = DaoFactory.createUsuarioDao(getHandler());

        _logger.debug(String.format("Dejando ModifyUsuarioCommand.ctor: attribute {%s}",
                _usuario.toString()));
    }

    @Override
    public void execute() {
        _logger.debug("Tomando de ModifyUsuarioCommand.execute");
        try {
            _usuario = _dao.update(_usuario);
        }catch(NullPointerException e){

        }
        _logger.debug("Dejando en ModifyUsuarioCommand.execute");
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
