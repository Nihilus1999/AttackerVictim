package com.ucab.cmcapp.logic.commands.historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetHistoricoCommand extends Command<Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetHistoricoCommand.class);
    private Historico_Usuario _Historico_Usuario;
    long _id;

    public GetHistoricoCommand(Historico_Usuario Historico_Usuario) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetHistorico_UsuarioCommand.ctor: parameter {%s}",
                Historico_Usuario.toString()));
        _id = Historico_Usuario.get_id();
        _Historico_Usuario = Historico_Usuario;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetHistorico_UsuarioCommand.ctor: attribute {%s}",
                _Historico_Usuario.toString()));
        //endregion
    }

    @Override
    public void execute() {
        try {
            GetHistoricoByIdCommand getHistorico_UsuarioByIdCommand = CommandFactory.createGetHistorico_UsuarioByIdCommand(getHandler(), _id);
            getHistorico_UsuarioByIdCommand.execute();
            _Historico_Usuario = getHistorico_UsuarioByIdCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Historico_Usuario getReturnParam() {
        return _Historico_Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
