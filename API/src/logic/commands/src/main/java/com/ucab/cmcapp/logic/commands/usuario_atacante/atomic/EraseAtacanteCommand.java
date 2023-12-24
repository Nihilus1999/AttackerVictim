package com.ucab.cmcapp.logic.commands.usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;

public class EraseAtacanteCommand extends Command<Usuario_Atacante> {

    private Usuario_Atacante _Usuario_Atacante;
    private Usuario_AtacanteDao _dao;

    public EraseAtacanteCommand(Usuario_Atacante Usuario_Atacante, DBHandler handler) {
        setHandler(handler);
        _Usuario_Atacante = Usuario_Atacante;
        _dao = DaoFactory.createUsuario_AtacanteDao(getHandler());
    }

    @Override
    public void execute() {
        _Usuario_Atacante = _dao.delete(_Usuario_Atacante);
    }

    @Override
    public Usuario_Atacante getReturnParam() {
        return _Usuario_Atacante;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
