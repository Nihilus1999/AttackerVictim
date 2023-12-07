package com.ucab.cmcapp.logic.commands.usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;

public class ModifyVictimaCommand extends Command<Usuario_Victima> {

    private Usuario_Victima _Usuario_Victima;
    private Usuario_VictimaDao _dao;

    public ModifyVictimaCommand(Usuario_Victima Usuario_Victima, DBHandler handler) {
        setHandler(handler);
        _Usuario_Victima = Usuario_Victima;
        _dao = DaoFactory.createUsuario_VictimaDao(getHandler());
    }

    @Override
    public void execute() {
        _Usuario_Victima = _dao.update(_Usuario_Victima);
    }

    @Override
    public Usuario_Victima getReturnParam() {
        return _Usuario_Victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}