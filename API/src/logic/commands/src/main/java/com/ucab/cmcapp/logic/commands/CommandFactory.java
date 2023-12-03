package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.*;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.*;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.*;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.*;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.*;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.*;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    //COMMAND DE USUARIO

    // GET USUARIO
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

    public static GetUsuarioByMacCommand createGetUsuarioByMacCommand(Usuario usuario){
        return new GetUsuarioByMacCommand(usuario);
    }

    public static GetAllUsuarioCommand createGetAllUsuarioCommand(){
        return new GetAllUsuarioCommand();
    }

    public static GetUsuarioByListCommand createGetUsuarioByListCommand(DBHandler handler) {
        return new GetUsuarioByListCommand(handler);
    }

    /*public static GetUsuarioByCorreoCommand createGetUsuarioByCorreoCommand(User user, DBHandler handler) {
        return new GetUserByEmailCommand(user, handler);
    }*/

    //POST/AGREGAR USUARIO
    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new AddUsuarioCommand(usuario, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario) {
        return new CreateUsuarioCommand(usuario);
    }

    //DELETE USUARIO

    public static DeleteUsuarioCommand createDeleteUsuarioCommand(Usuario usuario) {
        return new DeleteUsuarioCommand(usuario);
    }

    public static EraseUsuarioCommand createEraseUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new EraseUsuarioCommand(usuario, handler);
    }

    //UPDATE USUARIO
    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario){
        return new UpdateUsuarioCommand(usuario);
    }

    public static ModifyUsuarioCommand createModifyUsuarioCommand(Usuario usuario, DBHandler handler){
        return new ModifyUsuarioCommand(usuario, handler);
    }


    // COMMAND DE HISTORICO_USUARIO

    // GET HISTORICO_USUARIO
    public static GetHistoricoCommand createGetHistorico_UsuarioCommand(Historico_Usuario historicoUsuario) {
        return new GetHistoricoCommand(historicoUsuario);
    }

    public static GetHistoricoByIdCommand createGetHistorico_UsuarioByIdCommand(DBHandler handler, long historicoId) {
        return new GetHistoricoByIdCommand(handler, historicoId);
    }

    public static GetAllHistoricoCommand createGetAllHistorico_UsuarioCommand(){
        return new GetAllHistoricoCommand();
    }

    public static GetHistoricoByListCommand createGetHistorico_UsuarioByListCommand(DBHandler handler) {
        return new GetHistoricoByListCommand(handler);
    }


    // POST/AGREGAR HISTORICO_USUARIO
    public static AddHistoricoCommand createAddHistorico_UsuarioCommand(Historico_Usuario historicoUsuario, DBHandler handler) {
        return new AddHistoricoCommand(historicoUsuario, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateHistoricoCommand createCreateHistorico_UsuarioCommand(Historico_Usuario historico_Usuario) {
        return new CreateHistoricoCommand(historico_Usuario);
    }

    //DELETE HISTORICO_USUARIO

    public static DeleteHistoricoCommand createDeleteHistorico_UsuarioCommand(Historico_Usuario historicoUsuario) {
        return new DeleteHistoricoCommand(historicoUsuario);
    }

    public static EraseHistoricoCommand createEraseHistorico_UsuarioCommand(Historico_Usuario historicoUsuario, DBHandler handler) {
        return new EraseHistoricoCommand(historicoUsuario, handler);
    }

    //UPDATE HISTORICO_USUARIO
    public static UpdateHistoricoCommand createUpdateHistorico_UsuarioCommand(Historico_Usuario historicoUsuario){
        return new UpdateHistoricoCommand(historicoUsuario);
    }

    public static ModifyHistoricoCommand createModifyHistorico_UsuarioCommand(Historico_Usuario historicoUsuario, DBHandler handler){
        return new ModifyHistoricoCommand(historicoUsuario, handler);
    }



    // COMMAND DE USUARIO_VICTIMA

    // GET USUARIO_VICTIMA
    public static GetVictimaCommand createGetUsuario_VictimaCommand(Usuario_Victima usuarioVictima) {
        return new GetVictimaCommand(usuarioVictima);
    }

    public static GetVictimaByIdCommand createGetUsuario_VictimaByIdCommand(DBHandler handler, long victimaId) {
        return new GetVictimaByIdCommand(handler, victimaId);
    }

    public static GetAllVictimaCommand createGetAllUsuario_VictimaCommand(){
        return new GetAllVictimaCommand();
    }

    public static GetVictimaByListCommand createGetUsuario_VictimaByListCommand(DBHandler handler) {
        return new GetVictimaByListCommand(handler);
    }


    // POST/AGREGAR USUARIO_VICTIMA
    public static AddVictimaCommand createAddUsuario_VictimaCommand(Usuario_Victima usuarioVictima, DBHandler handler) {
        return new AddVictimaCommand(usuarioVictima, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateVictimaCommand createCreateUsuario_VictimaCommand(Usuario_Victima usuarioVictima) {
        return new CreateVictimaCommand(usuarioVictima);
    }

    //DELETE USUARIO_VICTIMA

    public static DeleteVictimaCommand createDeleteUsuario_VictimaCommand(Usuario_Victima usuarioVictima) {
        return new DeleteVictimaCommand(usuarioVictima);
    }

    public static EraseVictimaCommand createEraseUsuario_VictimaCommand(Usuario_Victima usuarioVictima, DBHandler handler) {
        return new EraseVictimaCommand(usuarioVictima, handler);
    }

    //UPDATE USUARIO_VICTIMA
    public static UpdateVictimaCommand createUpdateUsuario_VictimaCommand(Usuario_Victima usuarioVictima){
        return new UpdateVictimaCommand(usuarioVictima);
    }

    public static ModifyVictimaCommand createModifyUsuario_VictimaCommand(Usuario_Victima usuarioVictima, DBHandler handler){
        return new ModifyVictimaCommand(usuarioVictima, handler);
    }

    // COMMAND DE USUARIO_ATACANTE

    // GET USUARIO_ATACANTE
    public static GetAtacanteCommand createGetUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante) {
        return new GetAtacanteCommand(usuarioAtacante);
    }

    public static GetAtacanteByIdCommand createGetUsuario_AtacanteByIdCommand(DBHandler handler, long atacanteId) {
        return new GetAtacanteByIdCommand(handler, atacanteId);
    }

    public static GetAllAtacanteCommand createGetAllUsuario_AtacanteCommand(){
        return new GetAllAtacanteCommand();
    }

    public static GetAtacanteByListCommand createGetUsuario_AtacanteByListCommand(DBHandler handler) {
        return new GetAtacanteByListCommand(handler);
    }


    // POST/AGREGAR USUARIO_ATACANTE
    public static AddAtacanteCommand createAddUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante, DBHandler handler) {
        return new AddAtacanteCommand(usuarioAtacante, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateAtacanteCommand createCreateUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante) {
        return new CreateAtacanteCommand(usuarioAtacante);
    }

    //DELETE USUARIO_ATACANTE

    public static DeleteAtacanteCommand createDeleteUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante) {
        return new DeleteAtacanteCommand(usuarioAtacante);
    }

    public static EraseAtacanteCommand createEraseUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante, DBHandler handler) {
        return new EraseAtacanteCommand(usuarioAtacante, handler);
    }

    //UPDATE USUARIO_ATACANTE
    public static UpdateAtacanteCommand createUpdateUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante){
        return new UpdateAtacanteCommand(usuarioAtacante);
    }

    public static ModifyAtacanteCommand createModifyUsuario_AtacanteCommand(Usuario_Atacante usuarioAtacante, DBHandler handler){
        return new ModifyAtacanteCommand(usuarioAtacante, handler);
    }



    // COMMAND DE ZONA_SEGURA

    // GET ZONA_SEGURA
    public static GetZonaCommand createGetZona_SeguraCommand(Zona_Segura zonaSegura) {
        return new GetZonaCommand(zonaSegura);
    }

    public static GetZonaByIdCommand createGetZona_SeguraByIdCommand(DBHandler handler, long historicoId) {
        return new GetZonaByIdCommand(handler, historicoId);
    }

    public static GetAllZonaCommand createGetAllZona_SeguraCommand(){
        return new GetAllZonaCommand();
    }

    public static GetZonaByListCommand createGetZona_SeguraByListCommand(DBHandler handler) {
        return new GetZonaByListCommand(handler);
    }


    // POST/AGREGAR ZONA_SEGURA
    public static AddZonaCommand createAddZona_SeguraCommand(Zona_Segura zonaSegura, DBHandler handler) {
        return new AddZonaCommand(zonaSegura, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateZonaCommand createCreateZona_SeguraCommand(Zona_Segura zona_segura) {
        return new CreateZonaCommand(zona_segura);
    }

    //DELETE ZONA_SEGURA

    public static DeleteZonaCommand createDeleteZona_SeguraCommand(Zona_Segura zonaSegura) {
        return new DeleteZonaCommand(zonaSegura);
    }

    public static EraseZonaCommand createEraseZona_SeguraCommand(Zona_Segura zonaSegura, DBHandler handler) {
        return new EraseZonaCommand(zonaSegura, handler);
    }

    //UPDATE ZONA_SEGURA
    public static UpdateZonaCommand createUpdateZona_SeguraCommand(Zona_Segura zonaSegura){
        return new UpdateZonaCommand(zonaSegura);
    }

    public static ModifyZonaCommand createModifyZona_SeguraCommand(Zona_Segura zonaSegura, DBHandler handler){
        return new ModifyZonaCommand(zonaSegura, handler);
    }




    // COMMAND DE COORDENADA

    // GET COORDENADA
    public static GetCoordenadaCommand createGetCoordenadaCommand(Coordenada coordenada) {
        return new GetCoordenadaCommand(coordenada);
    }

    public static GetCoordenadaByIdCommand createGetCoordenadaByIdCommand(DBHandler handler, long coordenadaId) {
        return new GetCoordenadaByIdCommand(handler, coordenadaId);
    }

    public static GetAllCoordenadaCommand createGetAllCoordenadaCommand(){
        return new GetAllCoordenadaCommand();
    }

    public static GetCoordenadaByListCommand createGetCoordenadaByListCommand(DBHandler handler) {
        return new GetCoordenadaByListCommand(handler);
    }


    // POST/AGREGAR COORDENADA
    public static AddCoordenadaCommand createAddCoordenadaCommand(Coordenada coordenada, DBHandler handler) {
        return new AddCoordenadaCommand(coordenada, handler);
    }

    /*public static AddUsuarioCommand createAddUsuarioCommand(User user) {
        return new AddUsuarioCommand(user);
    }*/

    public static CreateCoordenadaCommand createCreateCoordenadaCommand(Coordenada coordenada) {
        return new CreateCoordenadaCommand(coordenada);
    }

    //DELETE COORDENADA

    public static DeleteCoordenadaCommand createDeleteCoordenadaCommand(Coordenada coordenada) {
        return new DeleteCoordenadaCommand(coordenada);
    }

    public static EraseCoordenadaCommand createEraseCoordenadaCommand(Coordenada coordenada, DBHandler handler) {
        return new EraseCoordenadaCommand(coordenada, handler);
    }

    //UPDATE COORDENADA
    public static UpdateCoordenadaCommand createUpdateCoordenadaCommand(Coordenada coordenada){
        return new UpdateCoordenadaCommand(coordenada);
    }

    public static ModifyCoordenadaCommand createModifyCoordenadaCommand(Coordenada coordenada, DBHandler handler){
        return new ModifyCoordenadaCommand(coordenada, handler);
    }



}
