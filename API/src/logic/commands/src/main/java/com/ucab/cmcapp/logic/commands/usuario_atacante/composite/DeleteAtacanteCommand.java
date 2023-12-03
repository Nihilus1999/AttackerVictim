package com.ucab.cmcapp.logic.commands.usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.EraseAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteAtacanteCommand extends Command<Usuario_Atacante> {

    private Usuario_Atacante _Usuario_Atacante;
    private Usuario_Atacante _result;

    private EraseAtacanteCommand _eraseUsuario_AtacanteCommand;

    public DeleteAtacanteCommand(Usuario_Atacante Usuario_Atacante) {
        _Usuario_Atacante = Usuario_Atacante;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseUsuario_AtacanteCommand = CommandFactory.createEraseUsuario_AtacanteCommand(_Usuario_Atacante, getHandler());
            _eraseUsuario_AtacanteCommand.execute();
            _result = _eraseUsuario_AtacanteCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario_Atacante getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
