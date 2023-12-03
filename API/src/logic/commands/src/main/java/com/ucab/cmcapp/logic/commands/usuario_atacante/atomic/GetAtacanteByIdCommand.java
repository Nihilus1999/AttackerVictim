package com.ucab.cmcapp.logic.commands.usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAtacanteByIdCommand extends Command<Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(GetAtacanteByIdCommand.class);
    private long _userId;
    private Usuario_Atacante _result;
    private Usuario_AtacanteDao _dao;

    public GetAtacanteByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUsuario_AtacanteByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createUsuario_AtacanteDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUsuario_AtacanteByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetUsuario_AtacanteByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Usuario_Atacante.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetUsuario_AtacanteByIdCommand.execute");
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
}
