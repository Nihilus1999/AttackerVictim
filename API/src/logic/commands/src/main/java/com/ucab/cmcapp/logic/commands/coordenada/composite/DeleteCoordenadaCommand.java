package com.ucab.cmcapp.logic.commands.coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.EraseCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class DeleteCoordenadaCommand extends Command<Coordenada> {

    private Coordenada _Coordenada;
    private Coordenada _result;

    private EraseCoordenadaCommand _eraseCoordenadaCommand;

    public DeleteCoordenadaCommand(Coordenada Coordenada) {
        _Coordenada = Coordenada;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _eraseCoordenadaCommand = CommandFactory.createEraseCoordenadaCommand(_Coordenada, getHandler());
            _eraseCoordenadaCommand.execute();
            _result = _eraseCoordenadaCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Coordenada getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

    public void setEraseCoordenadaCommand(EraseCoordenadaCommand eraseCoordenadaCommand) {

    }
}
