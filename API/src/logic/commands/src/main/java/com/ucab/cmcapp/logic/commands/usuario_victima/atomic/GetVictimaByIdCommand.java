package com.ucab.cmcapp.logic.commands.usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetVictimaByIdCommand extends Command<Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(GetVictimaByIdCommand.class);
    private long _userId;
    private Usuario_Victima _result;
    private Usuario_VictimaDao _dao;

    public GetVictimaByIdCommand(DBHandler handler, long userId) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in GetUsuario_VictimaByIdCommand.ctor: parameter {%s}", userId));
        //endregion

        _userId = userId;
        setHandler(handler);
        _dao = DaoFactory.createUsuario_VictimaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving GetUsuario_VictimaByIdCommand.ctor: attribute {%s}", userId));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  GetUsuario_VictimaByIdCommand.execute");
        //endregion
        _result = _dao.find(_userId, Usuario_Victima.class);
        //region Instrumentation DEBUG
        _logger.debug("Leaving  GetUsuario_VictimaByIdCommand.execute");
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
