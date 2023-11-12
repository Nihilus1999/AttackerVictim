package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;

public class GetUsuarioByCedulaCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    public GetUsuarioByCedulaCommand(Usuario usuario) {
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        _usuario = _dao.getUserByCedula(_usuario.get_cedula());
    }

    @Override
    public Usuario getReturnParam() {
        return _usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}