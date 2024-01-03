package com.ucab.cmcapp.logic.commands.historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByListCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.GetHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllHistoricoCommand extends Command <Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetHistoricoCommand.class);
    private List<Historico_Usuario> _Historico_Usuario;

    public GetAllHistoricoCommand() {
        //region Instrumentation DEBUG

        setHandler(new DBHandler());

        //endregion
    }

    @Override
    public void execute() {
        try {
            GetHistoricoByListCommand getHistorico_UsuarioByListCommand = CommandFactory.createGetHistorico_UsuarioByListCommand(getHandler());
            getHistorico_UsuarioByListCommand.execute();
            _Historico_Usuario = getHistorico_UsuarioByListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List <Historico_Usuario> getReturnParam() {
        return _Historico_Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setGetHistoricoByListCommand(GetHistoricoByListCommand getHistoricoByListCommand) {

    }
}
