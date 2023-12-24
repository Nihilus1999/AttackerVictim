package com.ucab.cmcapp.logic.commands.historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.AddHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateHistoricoCommand extends Command<Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(CreateHistoricoCommand.class);
    private Historico_Usuario _Historico_Usuario;
    private Historico_Usuario _result;
    private AddHistoricoCommand _addHistorico_UsuarioCommand;

    public CreateHistoricoCommand(Historico_Usuario Historico_Usuario) {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateHistorico_UsuarioCommand.ctor");
        //endregion

        _Historico_Usuario = Historico_Usuario;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateHistorico_UsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Entering CreateHistorico_UsuarioCommand.execute");
        //endregion

        try {
            getHandler().beginTransaction();
            _addHistorico_UsuarioCommand = CommandFactory.createAddHistorico_UsuarioCommand(_Historico_Usuario, getHandler());
            _addHistorico_UsuarioCommand.execute();
            _result = _addHistorico_UsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug("Leaving CreateHistorico_UsuarioCommand.execute");
        //endregion
    }

    @Override
    public Historico_Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
