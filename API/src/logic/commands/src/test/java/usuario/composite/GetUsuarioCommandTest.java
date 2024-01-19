package usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetUsuarioCommandTest {
    private GetUsuarioCommand getUsuarioCommand;
    private Usuario usuario;
    private GetUsuarioByIdCommand getUsuarioByIdCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        getUsuarioByIdCommand = Mockito.mock(GetUsuarioByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getUsuarioCommand = new GetUsuarioCommand(usuario);
        getUsuarioCommand.setHandler(dbHandler);
        getUsuarioCommand.setGetUsuarioByIdCommand(getUsuarioByIdCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Usuario retrievedUsuario = new Usuario();
        when(getUsuarioByIdCommand.getReturnParam()).thenReturn(retrievedUsuario);

        // Act
        getUsuarioCommand.execute();

        // Assert
        verify(getUsuarioByIdCommand,times(0)).execute();
        assertNotEquals(retrievedUsuario, getUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario result = new Usuario();

        // Act
        Usuario returnParam = getUsuarioCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}