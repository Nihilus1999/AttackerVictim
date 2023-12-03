package com.ucab.cmcapp.logic.commands.usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetVictimaCommand extends Command<Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaCommand.class);
    private Usuario_Victima _Usuario_Victima;
    long _id;

    public GetVictimaCommand(Usuario_Victima Usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUsuario_VictimaCommand.ctor: parameter {%s}",
                Usuario_Victima.toString()));
        _id = Usuario_Victima.get_id();
        _Usuario_Victima = Usuario_Victima;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUsuario_VictimaCommand.ctor: attribute {%s}",
                _Usuario_Victima.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetVictimaByIdCommand getUsuario_VictimaByIdCommand = CommandFactory.createGetUsuario_VictimaByIdCommand(getHandler(), _id);
            getUsuario_VictimaByIdCommand.execute();
            _Usuario_Victima = getUsuario_VictimaByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
