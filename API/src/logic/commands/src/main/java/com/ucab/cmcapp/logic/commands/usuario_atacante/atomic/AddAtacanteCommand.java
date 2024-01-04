package com.ucab.cmcapp.logic.commands.usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAtacanteCommand extends Command<Usuario_Atacante> {
    private static Logger _logger = LoggerFactory.getLogger(AddAtacanteCommand.class);
    private Usuario_Atacante _Usuario_Atacante;
    private Usuario_AtacanteDao _dao;

    public AddAtacanteCommand(Usuario_Atacante Usuario_Atacante, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddUsuario_AtacanteCommand.ctor: parameter {%s}",
                Usuario_Atacante.toString()));
        setHandler(handler);
        _Usuario_Atacante = Usuario_Atacante;
        _dao = DaoFactory.createUsuario_AtacanteDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddUsuario_AtacanteCommand.ctor: attribute {%s}",
                _Usuario_Atacante.toString()));
        //endregion
    }


    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddUsuario_AtacanteCommand.execute");
        //endregion
        try {
            _Usuario_Atacante = _dao.insert(_Usuario_Atacante);
        }catch(NullPointerException e){

        }
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddUsuario_AtacanteCommand.execute");
        //endregion
    }

    @Override
    public Usuario_Atacante getReturnParam() {
        return _Usuario_Atacante;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setDao(Usuario_AtacanteDao usuarioAtacanteDao) {
    }
}
