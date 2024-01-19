package com.ucab.cmcapp.logic.commands.usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.EraseVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteVictimaCommand extends Command<Usuario_Victima> {

    private Usuario_Victima _Usuario_Victima;
    private Usuario_Victima _result;

    private EraseVictimaCommand _eraseUsuario_VictimaCommand;

    public DeleteVictimaCommand(Usuario_Victima Usuario_Victima) {
        _Usuario_Victima = Usuario_Victima;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseUsuario_VictimaCommand = CommandFactory.createEraseUsuario_VictimaCommand(_Usuario_Victima, getHandler());
            _eraseUsuario_VictimaCommand.execute();
            _result = _eraseUsuario_VictimaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario_Victima getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setCommandFactory(CommandFactory commandFactory) {
    }
}
