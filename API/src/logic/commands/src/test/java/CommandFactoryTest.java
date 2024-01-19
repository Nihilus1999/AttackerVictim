import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.*;
import com.ucab.cmcapp.logic.commands.administrador.composite.*;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.*;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.*;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.*;
import com.ucab.cmcapp.logic.commands.notificacion.composite.*;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionAtacanteByRelacionIdCommand;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionByRelacionIDCommand;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionVictimaByRelacionIdCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.*;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.*;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.*;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.*;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.*;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.*;
import com.ucab.cmcapp.persistence.DBHandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CommandFactoryTest {

    @Test
    public void testCreateGetAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        GetAdministradorCommand command = CommandFactory.createGetAdministradorCommand(administrador);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateGetAdministradorByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long adminId = 1L;

        // Act
        GetAdministradorByIdCommand command = CommandFactory.createGetAdministradorByIdCommand(handler, adminId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(adminId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAdministradorByCorreoCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        GetAdministradorByCorreoCommand command = CommandFactory.createGetAdministradorByCorreoCommand(administrador);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateGetAdministradorByAliasCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        GetAdministradorByAliasCommand command = CommandFactory.createGetAdministradorByAliasCommand(administrador);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateGetAdministradorByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetAdministradorByListCommand command = CommandFactory.createGetAdministradorByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetAllAdministradorCommand() {
        // Act
        GetAllAdministradorCommand command = CommandFactory.createGetAllAdministradorCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateAddAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        AddAdministradorCommand command = CommandFactory.createAddAdministradorCommand(administrador, handler);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        CreateAdministradorCommand command = CommandFactory.createCreateAdministradorCommand(administrador);

        // Assert
        assertNotNull(command);
        assertNotEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        DeleteAdministradorCommand command = CommandFactory.createDeleteAdministradorCommand(administrador);

        // Assert
        assertNotNull(command);
        assertNotEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateEraseAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        EraseAdministradorCommand command = CommandFactory.createEraseAdministradorCommand(administrador, handler);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);

        // Act
        UpdateAdministradorCommand command = CommandFactory.createUpdateAdministradorCommand(administrador);

        // Assert
        assertNotNull(command);
        assertNotEquals(administrador, command.getReturnParam());
    }

    @Test
    public void testCreateModifyAdministradorCommand() {
        // Arrange
        Administrador administrador = mock(Administrador.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        ModifyAdministradorCommand command = CommandFactory.createModifyAdministradorCommand(administrador, handler);

        // Assert
        assertNotNull(command);
        assertEquals(administrador, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        GetUsuarioCommand command = CommandFactory.createGetUsuarioCommand(usuario);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuarioByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long userId = 123;

        // Act
        GetUsuarioByIdCommand command = CommandFactory.createGetUsuarioByIdCommand(handler, userId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(userId, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuarioByCorreoCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        GetUsuarioByCorreoCommand command = CommandFactory.createGetUsuarioByCorreoCommand(usuario);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuarioByAliasCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        GetUsuarioByAliasCommand command = CommandFactory.createGetUsuarioByAliasCommand(usuario);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuarioByCedulaCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        GetUsuarioByCedulaCommand command = CommandFactory.createGetUsuarioByCedulaCommand(usuario);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuarioByMacCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        GetUsuarioByMacCommand command = CommandFactory.createGetUsuarioByMacCommand(usuario);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllUsuarioCommand() {
        // Act
        GetAllUsuarioCommand command = CommandFactory.createGetAllUsuarioCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetUsuarioByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetUsuarioByListCommand command = CommandFactory.createGetUsuarioByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateAddUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        AddUsuarioCommand command = CommandFactory.createAddUsuarioCommand(usuario, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        CreateUsuarioCommand command = CommandFactory.createCreateUsuarioCommand(usuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        DeleteUsuarioCommand command = CommandFactory.createDeleteUsuarioCommand(usuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateEraseUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        EraseUsuarioCommand command = CommandFactory.createEraseUsuarioCommand(usuario, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);

        // Act
        UpdateUsuarioCommand command = CommandFactory.createUpdateUsuarioCommand(usuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuario, command.getReturnParam());
    }

    @Test
    public void testCreateModifyUsuarioCommand() {
        // Arrange
        Usuario usuario = mock(Usuario.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        ModifyUsuarioCommand command = CommandFactory.createModifyUsuarioCommand(usuario, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuario, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);

        // Act
        GetHistoricoCommand command = CommandFactory.createGetHistorico_UsuarioCommand(historicoUsuario);

        // Assert
        assertNotNull(command);
        assertEquals(historicoUsuario, command.getReturnParam());
    }

    @Test
    public void testCreateGetHistorico_UsuarioByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long historicoId = 12345L;

        // Act
        GetHistoricoByIdCommand command = CommandFactory.createGetHistorico_UsuarioByIdCommand(handler, historicoId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(historicoId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllHistorico_UsuarioCommand() {
        // Act
        GetAllHistoricoCommand command = CommandFactory.createGetAllHistorico_UsuarioCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetHistorico_UsuarioByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetHistoricoByListCommand command = CommandFactory.createGetHistorico_UsuarioByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetHistorico_UsuarioByUsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);

        // Act
        GetHistoricoByUsuarioIdCommand command = CommandFactory.createGetHistorico_UsuarioByUsuarioCommand(historicoUsuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(historicoUsuario, command.getReturnParam());
    }

    @Test
    public void testCreateAddHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        AddHistoricoCommand command = CommandFactory.createAddHistorico_UsuarioCommand(historicoUsuario, handler);

        // Assert
        assertNotNull(command);
        assertEquals(historicoUsuario, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);

        // Act
        CreateHistoricoCommand command = CommandFactory.createCreateHistorico_UsuarioCommand(historicoUsuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(historicoUsuario, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);

        // Act
        DeleteHistoricoCommand command = CommandFactory.createDeleteHistorico_UsuarioCommand(historicoUsuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(historicoUsuario, command.getReturnParam());
    }

    @Test
    public void testCreateEraseHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);
        DBHandler handler = mock(DBHandler.class);

        // Act
        EraseHistoricoCommand command = CommandFactory.createEraseHistorico_UsuarioCommand(historicoUsuario, handler);

        // Assert
        assertNotNull(command);
        assertEquals(historicoUsuario, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateHistorico_UsuarioCommand() {
        // Arrange
        Historico_Usuario historicoUsuario = mock(Historico_Usuario.class);

        // Act
        UpdateHistoricoCommand command = CommandFactory.createUpdateHistorico_UsuarioCommand(historicoUsuario);

        // Assert
        assertNotNull(command);
        assertNotEquals(historicoUsuario, command.getReturnParam());
    }

    @Test
    public void testCreateModifyHistorico_UsuarioCommand() {
        // Preparación de datos de prueba
        Historico_Usuario historicoUsuario = new Historico_Usuario();
        DBHandler handler = Mockito.mock(DBHandler.class);


        // Lógica de prueba
        ModifyHistoricoCommand command = CommandFactory.createModifyHistorico_UsuarioCommand(historicoUsuario, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(historicoUsuario, command.getReturnParam());
        Assertions.assertNotEquals(handler, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();

        // Lógica de prueba
        GetVictimaCommand command = CommandFactory.createGetUsuario_VictimaCommand(usuarioVictima);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioVictima, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuario_VictimaByIdCommand() {
        // Preparación de datos de prueba
        DBHandler handler = Mockito.mock(DBHandler.class);
        long victimaId = 12345;

        // Lógica de prueba
        GetVictimaByIdCommand command = CommandFactory.createGetUsuario_VictimaByIdCommand(handler, victimaId);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(handler, command.getReturnParam());
        Assertions.assertNotEquals(victimaId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllUsuario_VictimaCommand() {
        // Lógica de prueba
        GetAllVictimaCommand command = CommandFactory.createGetAllUsuario_VictimaCommand();

        // Verificación de resultados
        Assertions.assertNotNull(command);
    }

    @Test
    public void testCreateGetUsuario_VictimaByListCommand() {
        // Preparación de datos de prueba
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        GetVictimaByListCommand command = CommandFactory.createGetUsuario_VictimaByListCommand(handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(handler, command.getReturnParam());
    }

    @Test
    public void testCreateAddUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        AddVictimaCommand command = CommandFactory.createAddUsuario_VictimaCommand(usuarioVictima, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioVictima, command.getReturnParam());
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();

        // Lógica de prueba
        CreateVictimaCommand command = CommandFactory.createCreateUsuario_VictimaCommand(usuarioVictima);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(usuarioVictima, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();

        // Lógica de prueba
        DeleteVictimaCommand command = CommandFactory.createDeleteUsuario_VictimaCommand(usuarioVictima);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(usuarioVictima, command.getReturnParam());
    }

    @Test
    public void testCreateEraseUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        EraseVictimaCommand command = CommandFactory.createEraseUsuario_VictimaCommand(usuarioVictima, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioVictima, command.getReturnParam());
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();

        // Lógica de prueba
        UpdateVictimaCommand command = CommandFactory.createUpdateUsuario_VictimaCommand(usuarioVictima);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(usuarioVictima, command.getReturnParam());
    }

    @Test
    public void testCreateModifyUsuario_VictimaCommand() {
        // Preparación de datos de prueba
        Usuario_Victima usuarioVictima = new Usuario_Victima();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        ModifyVictimaCommand command = CommandFactory.createModifyUsuario_VictimaCommand(usuarioVictima, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioVictima, command.getReturnParam());
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetUsuario_AtacanteCommand() {
        // Preparación de datos de prueba
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();

        // Lógica de prueba
        GetAtacanteCommand command = CommandFactory.createGetUsuario_AtacanteCommand(usuarioAtacante);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioAtacante, command.getReturnParam());
    }

    @Test
    public void testCreateGetUsuario_AtacanteByIdCommand() {
        // Preparación de datos de prueba
        DBHandler handler = Mockito.mock(DBHandler.class);
        long atacanteId = 67890;

        // Lógica de prueba
        GetAtacanteByIdCommand command = CommandFactory.createGetUsuario_AtacanteByIdCommand(handler, atacanteId);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(handler, command.getHandler());
        Assertions.assertNotEquals(atacanteId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllUsuario_AtacanteCommand() {
        // Lógica de prueba
        GetAllAtacanteCommand command = CommandFactory.createGetAllUsuario_AtacanteCommand();

        // Verificación de resultados
        Assertions.assertNotNull(command);
    }

    @Test
    public void testCreateGetUsuario_AtacanteByListCommand() {
        // Preparación de datos de prueba
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        GetAtacanteByListCommand command = CommandFactory.createGetUsuario_AtacanteByListCommand(handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateAddUsuario_AtacanteCommand() {
        // Preparación de datos de prueba
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        AddAtacanteCommand command = CommandFactory.createAddUsuario_AtacanteCommand(usuarioAtacante, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioAtacante, command.getReturnParam());
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateUsuario_AtacanteCommand() {
        // Preparación de datos de prueba
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();

        // Lógica de prueba
        CreateAtacanteCommand command = CommandFactory.createCreateUsuario_AtacanteCommand(usuarioAtacante);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(usuarioAtacante, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteUsuario_AtacanteCommand() {
        // Preparación de datos de prueba
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();

        // Lógica de prueba
        DeleteAtacanteCommand command = CommandFactory.createDeleteUsuario_AtacanteCommand(usuarioAtacante);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertNotEquals(usuarioAtacante, command.getReturnParam());
    }

    @Test
    public void testCreateEraseUsuario_AtacanteCommand() {
        // Preparación de datos de prueba
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Lógica de prueba
        EraseAtacanteCommand command = CommandFactory.createEraseUsuario_AtacanteCommand(usuarioAtacante, handler);

        // Verificación de resultados
        Assertions.assertNotNull(command);
        Assertions.assertEquals(usuarioAtacante, command.getReturnParam());
        Assertions.assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateUsuario_AtacanteCommand() {
        // Arrange
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();

        // Act
        UpdateAtacanteCommand command = CommandFactory.createUpdateUsuario_AtacanteCommand(usuarioAtacante);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuarioAtacante, command.getReturnParam());
    }

    @Test
    public void testCreateModifyUsuario_AtacanteCommand() {
        // Arrange
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();
        DBHandler handler = mock(DBHandler.class);

        // Act
        ModifyAtacanteCommand command = CommandFactory.createModifyUsuario_AtacanteCommand(usuarioAtacante, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuarioAtacante, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();

        // Act
        GetRelacionCommand command = CommandFactory.createGetRelacion_VACommand(usuarioRelacion);

        // Assert
        assertNotNull(command);
        assertEquals(usuarioRelacion, command.getReturnParam());
    }

    @Test
    public void testCreateGetRelacion_VAByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long atacanteId = 123456;

        // Act
        GetRelacionByIdCommand command = CommandFactory.createGetRelacion_VAByIdCommand(handler, atacanteId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(atacanteId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllRelacion_VACommand() {
        // Arrange

        // Act
        GetAllRelacionCommand command = CommandFactory.createGetAllRelacion_VACommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetRelacion_VAByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetRelacionByListCommand command = CommandFactory.createGetRelacion_VAByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetPosicionByRelacionIDCommand() {
        // Arrange
        Relacion_VA relacion = new Relacion_VA();

        // Act
        GetPosicionByRelacionIDCommand command = CommandFactory.createGetPosicionByRelacionIDCommand(relacion);

        // Assert
        assertNotNull(command);
        assertNotEquals(relacion, command.getReturnParam());
    }

    @Test
    public void testCreateAddRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();
        DBHandler handler = mock(DBHandler.class);

        // Act
        AddRelacionCommand command = CommandFactory.createAddRelacion_VACommand(usuarioRelacion, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuarioRelacion, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();

        // Act
        CreateRelacionCommand command = CommandFactory.createCreateRelacion_VACommand(usuarioRelacion);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuarioRelacion, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();

        // Act
        DeleteRelacionCommand command = CommandFactory.createDeleteRelacion_VACommand(usuarioRelacion);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuarioRelacion, command.getReturnParam());
    }

    @Test
    public void testCreateEraseRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();
        DBHandler handler = mock(DBHandler.class);

        // Act
        EraseRelacionCommand command = CommandFactory.createEraseRelacion_VACommand(usuarioRelacion, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuarioRelacion, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();

        // Act
        UpdateRelacionCommand command = CommandFactory.createUpdateRelacion_VACommand(usuarioRelacion);

        // Assert
        assertNotNull(command);
        assertNotEquals(usuarioRelacion, command.getReturnParam());
    }

    @Test
    public void testCreateModifyRelacion_VACommand() {
        // Arrange
        Relacion_VA usuarioRelacion = new Relacion_VA();
        DBHandler handler = mock(DBHandler.class);

        // Act
        ModifyRelacionCommand command = CommandFactory.createModifyRelacion_VACommand(usuarioRelacion, handler);

        // Assert
        assertNotNull(command);
        assertEquals(usuarioRelacion, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        GetZonaCommand command = CommandFactory.createGetZona_SeguraCommand(zonaSegura);

        // Assert
        assertNotNull(command);
        assertEquals(zonaSegura, command.getReturnParam());
    }

    @Test
    public void testCreateGetZona_SeguraByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long historicoId = 12345;

        // Act
        GetZonaByIdCommand command = CommandFactory.createGetZona_SeguraByIdCommand(handler, historicoId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(historicoId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllZona_SeguraCommand() {
        // Arrange

        // Act
        GetAllZonaCommand command = CommandFactory.createGetAllZona_SeguraCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetZona_SeguraByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetZonaByListCommand command = CommandFactory.createGetZona_SeguraByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetZona_SeguraByVictimaCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        GetZonaByVictimaIdCommand command = CommandFactory.createGetZona_SeguraByVictimaCommand(zonaSegura);

        // Assert
        assertNotNull(command);
        assertNotEquals(zonaSegura, command.getReturnParam());
    }

    @Test
    public void testCreateAddZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();
        DBHandler handler = mock(DBHandler.class);

        // Act
        AddZonaCommand command = CommandFactory.createAddZona_SeguraCommand(zonaSegura, handler);

        // Assert
        assertNotNull(command);
        assertEquals(zonaSegura, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        CreateZonaCommand command = CommandFactory.createCreateZona_SeguraCommand(zonaSegura);

        // Assert
        assertNotNull(command);
        assertNotEquals(zonaSegura, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        DeleteZonaCommand command = CommandFactory.createDeleteZona_SeguraCommand(zonaSegura);

        // Assert
        assertNotNull(command);
        assertNotEquals(zonaSegura, command.getReturnParam());
    }

    @Test
    public void testCreateEraseZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();
        DBHandler handler = mock(DBHandler.class);

        // Act
        EraseZonaCommand command = CommandFactory.createEraseZona_SeguraCommand(zonaSegura, handler);

        // Assert
        assertNotNull(command);
        assertEquals(zonaSegura, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        UpdateZonaCommand command = CommandFactory.createUpdateZona_SeguraCommand(zonaSegura);

        // Assert
        assertNotNull(command);
        assertNotEquals(zonaSegura, command.getReturnParam());
    }

    @Test
    public void testCreateModifyZona_SeguraCommand() {
        // Arrange
        Zona_Segura zonaSegura = new Zona_Segura();
        DBHandler handler = mock(DBHandler.class);

        // Act
        ModifyZonaCommand command = CommandFactory.createModifyZona_SeguraCommand(zonaSegura, handler);

        // Assert
        assertNotNull(command);
        assertEquals(zonaSegura, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();

        // Act
        GetCoordenadaCommand command = CommandFactory.createGetCoordenadaCommand(coordenada);

        // Assert
        assertNotNull(command);
        assertEquals(coordenada, command.getReturnParam());
    }

    @Test
    public void testCreateGetCoordenadaByIdCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        long coordenadaId = 54321;

        // Act
        GetCoordenadaByIdCommand command = CommandFactory.createGetCoordenadaByIdCommand(handler, coordenadaId);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
        assertNotEquals(coordenadaId, command.getReturnParam());
    }

    @Test
    public void testCreateGetAllCoordenadaCommand() {
        // Act
        GetAllCoordenadaCommand command = CommandFactory.createGetAllCoordenadaCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetCoordenadaByListCommand() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        GetCoordenadaByListCommand command = CommandFactory.createGetCoordenadaByListCommand(handler);

        // Assert
        assertNotNull(command);
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateAddCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Act
        AddCoordenadaCommand command = CommandFactory.createAddCoordenadaCommand(coordenada, handler);

        // Assert
        assertNotNull(command);
        assertEquals(coordenada, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateCreateCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();

        // Act
        CreateCoordenadaCommand command = CommandFactory.createCreateCoordenadaCommand(coordenada);

        // Assert
        assertNotNull(command);
        assertNotEquals(coordenada, command.getReturnParam());
    }

    @Test
    public void testCreateDeleteCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();

        // Act
        DeleteCoordenadaCommand command = CommandFactory.createDeleteCoordenadaCommand(coordenada);

        // Assert
        assertNotNull(command);
        assertNotEquals(coordenada, command.getReturnParam());
    }

    @Test
    public void testCreateEraseCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Act
        EraseCoordenadaCommand command = CommandFactory.createEraseCoordenadaCommand(coordenada, handler);

        // Assert
        assertNotNull(command);
        assertEquals(coordenada, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateUpdateCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();

        // Act
        UpdateCoordenadaCommand command = CommandFactory.createUpdateCoordenadaCommand(coordenada);

        // Assert
        assertNotNull(command);
        assertNotEquals(coordenada, command.getReturnParam());
    }

    @Test
    public void testCreateModifyCoordenadaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();
        DBHandler handler = Mockito.mock(DBHandler.class);

        // Act
        ModifyCoordenadaCommand command = CommandFactory.createModifyCoordenadaCommand(coordenada, handler);

        // Assert
        assertNotNull(command);
        assertEquals(coordenada, command.getReturnParam());
        assertEquals(handler, command.getHandler());
    }

    @Test
    public void testCreateGetCoordenadaByZonaCommand() {
        // Arrange
        Coordenada coordenada = new Coordenada();

        // Act
        GetCoordenadaByZonaIdCommand command = CommandFactory.createGetCoordenadaByZonaCommand(coordenada);

        // Assert
        assertNotNull(command);
        assertNotEquals(coordenada, command.getReturnParam());
    }

    @Test
    public void testCreateGetNotificacionCommand() {
        // Arrange
        Notificacion notificacionUsuario = new Notificacion();

        // Act
        GetNotificacionCommand command = CommandFactory.createGetNotificacionCommand(notificacionUsuario);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetNotificacionByIdCommand() {
        // Arrange
        DBHandler handler = new DBHandler();
        long notificacionId = 1;

        // Act
        GetNotificacionByIdCommand command = CommandFactory.createGetNotificacionByIdCommand(handler, notificacionId);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetAllNotificacionCommand() {
        // Act
        GetAllNotificacionCommand command = CommandFactory.createGetAllNotificacionCommand();

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetNotificacionByListCommand() {
        // Arrange
        DBHandler handler = new DBHandler();

        // Act
        GetNotificacionByListCommand command = CommandFactory.createGetNotificacionByListCommand(handler);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetNotificacionByUsuarioCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Act
        GetNotificacionByUsuarioIdCommand command = CommandFactory.createGetNotificacionByUsuarioCommand(notificacion);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateAddNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();
        DBHandler handler = new DBHandler();

        // Act
        AddNotificacionCommand command = CommandFactory.createAddNotificacionCommand(notificacion, handler);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateCreateNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Act
        CreateNotificacionCommand command = CommandFactory.createCreateNotificacionCommand(notificacion);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateDeleteNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Act
        DeleteNotificacionCommand command = CommandFactory.createDeleteNotificacionCommand(notificacion);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateEraseNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();
        DBHandler handler = new DBHandler();

        // Act
        EraseNotificacionCommand command = CommandFactory.createEraseNotificacionCommand(notificacion, handler);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateUpdateNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Act
        UpdateNotificacionCommand command = CommandFactory.createUpdateNotificacionCommand(notificacion);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateModifyNotificacionCommand() {
        // Arrange
        Notificacion notificacion = new Notificacion();
        DBHandler handler = new DBHandler();

        // Act
        ModifyNotificacionCommand command = CommandFactory.createModifyNotificacionCommand(notificacion, handler);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetPosicionAtacanteByRelacionIdCommand() {
        // Arrange
        Relacion_VA relacion = new Relacion_VA();

        // Act
        GetPosicionAtacanteByRelacionIdCommand command = CommandFactory.createGetPosicionAtacanteByRelacionIdCommand(relacion);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void testCreateGetPosicionVictimaByRelacionIdCommand() {
        // Arrange
        Relacion_VA relacion = new Relacion_VA();

        // Act
        GetPosicionVictimaByRelacionIdCommand command = CommandFactory.createGetPosicionVictimaByRelacionIdCommand(relacion);

        // Assert
        assertNotNull(command);
    }

}