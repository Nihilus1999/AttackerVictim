package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;

public class GetUsuarioByMacCommand extends Command<Usuario> {

    private Usuario _usuario;
    private UsuarioDao _dao;

    public GetUsuarioByMacCommand(Usuario usuario) {
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        try {
            _usuario = _dao.getUsuarioByMac(_usuario.get_direccion_mac());
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
