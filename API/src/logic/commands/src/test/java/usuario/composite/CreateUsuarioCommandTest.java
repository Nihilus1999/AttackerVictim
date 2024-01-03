package usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CreateUsuarioCommandTest {
    private CreateUsuarioCommand createUsuarioCommand;
    private Usuario usuario;
    private AddUsuarioCommand addUsuarioCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        addUsuarioCommand = Mockito.mock(AddUsuarioCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        createUsuarioCommand = new CreateUsuarioCommand(usuario);
        createUsuarioCommand.setAddUsuarioCommand(addUsuarioCommand);
        createUsuarioCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario createdUsuario = new Usuario();
        when(addUsuarioCommand.getReturnParam()).thenReturn(createdUsuario);

        // Act
        createUsuarioCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(addUsuarioCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(createdUsuario, createUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario result = new Usuario();

        // Act
        Usuario returnParam = createUsuarioCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
