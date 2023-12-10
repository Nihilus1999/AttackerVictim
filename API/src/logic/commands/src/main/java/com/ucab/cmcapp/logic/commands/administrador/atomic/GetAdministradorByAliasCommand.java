package com.ucab.cmcapp.logic.commands.administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;

public class GetAdministradorByAliasCommand extends Command<Administrador> {

    private Administrador _Administrador;
    private AdministradorDao _dao;

    public GetAdministradorByAliasCommand(Administrador Administrador) {
        _Administrador = Administrador;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAdministradorDao(getHandler());
    }

    @Override
    public void execute() {
        _Administrador = _dao.getAdministradorByAlias(_Administrador.get_alias());
    }

    @Override
    public Administrador getReturnParam() {
        return _Administrador;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}