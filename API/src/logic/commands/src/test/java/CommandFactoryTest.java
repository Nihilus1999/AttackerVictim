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

}