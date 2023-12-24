package com.ucab.cmcapp.logic.commands.usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateVictimaCommand extends Command<Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(CreateVictimaCommand.class);
    private Usuario_Victima _Usuario_Victima;
    private Usuario_Victima _result;
    private AddVictimaCommand _addUsuario_VictimaCommand;

    public CreateVictimaCommand(Usuario_Victima Usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateUsuario_VictimaCommand.ctor");
        //endregion

        _Usuario_Victima = Usuario_Victima;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateUsuario_VictimaCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateUsuario_VictimaCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addUsuario_VictimaCommand = CommandFactory.createAddUsuario_VictimaCommand(_Usuario_Victima, getHandler());
            _addUsuario_VictimaCommand.execute();
            _result = _addUsuario_VictimaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateUsuario_VictimaCommand.execute");
        //endregion
    }

    @Override
    public Usuario_Victima getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
