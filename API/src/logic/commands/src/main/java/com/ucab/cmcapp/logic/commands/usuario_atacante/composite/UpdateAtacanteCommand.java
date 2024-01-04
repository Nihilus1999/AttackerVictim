package com.ucab.cmcapp.logic.commands.usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.ModifyAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateAtacanteCommand extends Command<Usuario_Atacante> {

    private Usuario_Atacante _Usuario_Atacante;
    private Usuario_Atacante _result;
    private ModifyAtacanteCommand _modifyUsuario_AtacanteCommand;

    public UpdateAtacanteCommand(Usuario_Atacante Usuario_Atacante) {
        _Usuario_Atacante = Usuario_Atacante;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyUsuario_AtacanteCommand = CommandFactory.createModifyUsuario_AtacanteCommand(_Usuario_Atacante, getHandler());
            _modifyUsuario_AtacanteCommand.execute();
            _result = _modifyUsuario_AtacanteCommand.getReturnParam();
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

    public void setModifyAtacanteCommand(ModifyAtacanteCommand modifyAtacanteCommand) {

    }
}
