package com.ucab.cmcapp.logic.commands.usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddVictimaCommand extends Command<Usuario_Victima> {
    private static Logger _logger = LoggerFactory.getLogger(AddVictimaCommand.class);
    private Usuario_Victima _Usuario_Victima;
    private Usuario_VictimaDao _dao;

    public AddVictimaCommand(Usuario_Victima Usuario_Victima, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddUsuario_VictimaCommand.ctor: parameter {%s}",
                Usuario_Victima.toString()));
        setHandler(handler);
        _Usuario_Victima = Usuario_Victima;
        _dao = DaoFactory.createUsuario_VictimaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddUsuario_VictimaCommand.ctor: attribute {%s}",
                _Usuario_Victima.toString()));
        //endregion
    }

    public AddVictimaCommand(Usuario_Victima Usuario_Victima) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddUsuario_VictimaCommand.ctor: parameter {%s}",
                Usuario_Victima.toString()));
        _Usuario_Victima = Usuario_Victima;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuario_VictimaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddUsuario_VictimaCommand.ctor: attribute {%s}",
                _Usuario_Victima.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddUsuario_VictimaCommand.execute");
        //endregion

        _Usuario_Victima = _dao.insert(_Usuario_Victima);

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddUsuario_VictimaCommand.execute");
        //endregion
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
