package com.ucab.cmcapp.logic.commands.usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.GetAtacanteByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllAtacanteCommand extends Command <Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(GetAtacanteCommand.class);
    private List<Usuario_Atacante> _Usuario_Atacante;

    public GetAllAtacanteCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetAtacanteByListCommand getUsuario_AtacanteByListCommand = CommandFactory.createGetUsuario_AtacanteByListCommand(getHandler());
            getUsuario_AtacanteByListCommand.execute();
            _Usuario_Atacante = getUsuario_AtacanteByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Usuario_Atacante> getReturnParam() {
        return _Usuario_Atacante;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
