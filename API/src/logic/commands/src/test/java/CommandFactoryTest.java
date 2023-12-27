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

import org.junit.jupiter.api.Test;

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

}