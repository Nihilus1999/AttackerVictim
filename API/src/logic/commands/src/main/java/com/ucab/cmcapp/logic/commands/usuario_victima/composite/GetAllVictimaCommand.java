package com.ucab.cmcapp.logic.commands.usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllVictimaCommand extends Command <Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaCommand.class);
    private List<Usuario_Victima> _Usuario_Victima;

    public GetAllVictimaCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetVictimaByListCommand getUsuario_VictimaByListCommand = CommandFactory.createGetUsuario_VictimaByListCommand(getHandler());
            getUsuario_VictimaByListCommand.execute();
            _Usuario_Victima = getUsuario_VictimaByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Usuario_Victima> getReturnParam() {
        return _Usuario_Victima;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setCommandFactory(CommandFactory commandFactory) {

    }
}
