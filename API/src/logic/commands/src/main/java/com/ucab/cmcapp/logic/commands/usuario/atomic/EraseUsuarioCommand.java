package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;

public class EraseUsuarioCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    public EraseUsuarioCommand(Usuario usuario, DBHandler handler) {
        setHandler(handler);
        _usuario = usuario;
        _dao = DaoFactory.createUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        try{
            _usuario = _dao.delete(_usuario);
        }catch(NullPointerException e){

        }

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
