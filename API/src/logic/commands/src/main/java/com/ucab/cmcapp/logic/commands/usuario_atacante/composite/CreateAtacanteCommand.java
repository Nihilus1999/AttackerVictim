package com.ucab.cmcapp.logic.commands.usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.AddAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAtacanteCommand extends Command<Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(CreateAtacanteCommand.class);
    private Usuario_Atacante _Usuario_Atacante;
    private Usuario_Atacante _result;
    private AddAtacanteCommand _addUsuario_AtacanteCommand;

    public CreateAtacanteCommand(Usuario_Atacante Usuario_Atacante) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateUsuario_AtacanteCommand.ctor");
        //endregion

        _Usuario_Atacante = Usuario_Atacante;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateUsuario_AtacanteCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateUsuario_AtacanteCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addUsuario_AtacanteCommand = CommandFactory.createAddUsuario_AtacanteCommand(_Usuario_Atacante, getHandler());
            _addUsuario_AtacanteCommand.execute();
            _result = _addUsuario_AtacanteCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateUsuario_AtacanteCommand.execute");
        //endregion
    }

    @Override
    public Usuario_Atacante getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setAddAtacanteCommand(AddAtacanteCommand addAtacanteCommand) {

    }
}
