package com.ucab.cmcapp.logic.commands.usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.GetAtacanteByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAtacanteCommand extends Command<Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(GetAtacanteCommand.class);
    private Usuario_Atacante _Usuario_Atacante;
    long _id;

    public GetAtacanteCommand(Usuario_Atacante Usuario_Atacante) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUsuario_AtacanteCommand.ctor: parameter {%s}",
                Usuario_Atacante.toString()));
        _id = Usuario_Atacante.get_id();
        _Usuario_Atacante = Usuario_Atacante;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUsuario_AtacanteCommand.ctor: attribute {%s}",
                _Usuario_Atacante.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetAtacanteByIdCommand getUsuario_AtacanteByIdCommand = CommandFactory.createGetUsuario_AtacanteByIdCommand(getHandler(), _id);
            getUsuario_AtacanteByIdCommand.execute();
            _Usuario_Atacante = getUsuario_AtacanteByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
