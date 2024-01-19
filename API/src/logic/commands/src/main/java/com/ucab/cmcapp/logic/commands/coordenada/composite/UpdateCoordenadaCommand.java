package com.ucab.cmcapp.logic.commands.coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.ModifyCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class UpdateCoordenadaCommand extends Command<Coordenada> {

    private Coordenada _Coordenada;
    private Coordenada _result;
    private ModifyCoordenadaCommand _modifyCoordenadaCommand;

    public UpdateCoordenadaCommand(Coordenada Coordenada) {
        _Coordenada = Coordenada;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();
            _modifyCoordenadaCommand = CommandFactory.createModifyCoordenadaCommand(_Coordenada, getHandler());
            _modifyCoordenadaCommand.execute();
            _result = _modifyCoordenadaCommand.getReturnParam();
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

    public void setModifyCoordenadaCommand(ModifyCoordenadaCommand modifyCoordenadaCommand) {

    }
}
