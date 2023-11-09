package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario usuario) {
        return new GetUsuarioCommand(usuario);
    }

    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand(DBHandler handler, long userId) {
        return new GetUsuarioByIdCommand(handler, userId);
    }

    public static GetUsuarioByCorreoCommand createGetUsuarioByCorreoCommand(Usuario usuario) {
        return new GetUsuarioByCorreoCommand(usuario);
    }

    public static GetUsuarioByAliasCommand createGetUsuarioByAliasCommand(Usuario usuario){
        return new GetUsuarioByAliasCommand(usuario);
    }

    public static GetUsuarioByCedulaCommand createGetUsuarioByCedulaCommand(Usuario usuario){
        return new GetUsuarioByCedulaCommand(usuario);
    }

    /*public static GetUsuarioByCorreoCommand createGetUsuarioByCorreoCommand(User user, DBHandler handler) {
        return new GetUserByEmailCommand(user, handler);
    }*/


    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new AddUsuarioCommand(usuario, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario) {
        return new CreateUsuarioCommand(usuario);
    }

    public static DeleteUsuarioCommand createDeleteUsuarioCommand(Usuario usuario) {
        return new DeleteUsuarioCommand(usuario);
    }

    public static EraseUsuarioCommand createEraseUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new EraseUsuarioCommand(usuario, handler);
    }

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario){
        return new UpdateUsuarioCommand(usuario);
    }

    public static ModifyUsuarioCommand createModifyUsuarioCommand(Usuario usuario, DBHandler handler){
        return new ModifyUsuarioCommand(usuario, handler);
    }

    //public static UpdateUsuarioCommand - composite - primero

    // public static ModifyUsuarioCommand - atomic - este es el del handler

}
