package com.ucab.cmcapp.logic.commands.historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddHistoricoCommand extends Command<Historico_Usuario> {
    private static Logger _logger = LoggerFactory.getLogger(AddHistoricoCommand.class);
    private Historico_Usuario _Historico_Usuario;
    private Historico_UsuarioDao _dao;

    public AddHistoricoCommand(Historico_Usuario Historico_Usuario, DBHandler handler) {
        //region Instrumentation DEBUG
        _logger.debug(String.format("Get in AddHistorico_UsuarioCommand.ctor: parameter {%s}",
                Historico_Usuario.toString()));
        setHandler(handler);
        _Historico_Usuario = Historico_Usuario;
        _dao = DaoFactory.createHistorico_UsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug(String.format("Leaving AddHistorico_UsuarioCommand.ctor: attribute {%s}",
                _Historico_Usuario.toString()));
        //endregion
    }

    @Override
    public void execute() {
        //region Instrumentation DEBUG
        _logger.debug("Get in  AddHistorico_UsuarioCommand.execute");
        //endregion
        try {
            _Historico_Usuario = _dao.insert(_Historico_Usuario);
        }catch(NullPointerException e){

        }

        //region Instrumentation DEBUG
        _logger.debug("Get in  AddHistorico_UsuarioCommand.execute");
        //endregion
    }

    @Override
    public Historico_Usuario getReturnParam() {
        return _Historico_Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setHistoricoUsuarioDao(Historico_UsuarioDao historicoUsuarioDao) {

    }
}
