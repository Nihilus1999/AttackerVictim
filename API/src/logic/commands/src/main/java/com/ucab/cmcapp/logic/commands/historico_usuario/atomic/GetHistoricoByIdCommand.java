package com.ucab.cmcapp.logic.commands.historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetHistoricoByIdCommand extends Command<Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(GetHistoricoByIdCommand.class);
    private long _userId;
    private Historico_Usuario _result;
    private Historico_UsuarioDao _dao;

    public GetHistoricoByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetHistorico_UsuarioByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createHistorico_UsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetHistorico_UsuarioByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetHistorico_UsuarioByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Historico_Usuario.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetHistorico_UsuarioByIdCommand.execute");
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
