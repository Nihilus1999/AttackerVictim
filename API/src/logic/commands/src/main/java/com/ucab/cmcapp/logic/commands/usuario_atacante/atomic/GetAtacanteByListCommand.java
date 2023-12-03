package com.ucab.cmcapp.logic.commands.usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;

import java.util.List;

public class GetAtacanteByListCommand extends Command<Usuario_Atacante> {

    private List<Usuario_Atacante> _result;
    private Usuario_AtacanteDao _dao;

    public GetAtacanteByListCommand(DBHandler handler) {
        //region Instrumentation DEBUG
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createUsuario_AtacanteDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        //endregion
        _result = _dao.findAll(Usuario_Atacante.class);
        //region Instrumentation DEBUG
        //endregion
    }

    @Override
    public List <Usuario_Atacante> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }
}
