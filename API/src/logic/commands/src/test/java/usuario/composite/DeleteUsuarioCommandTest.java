package usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.EraseUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DeleteUsuarioCommandTest {
    private DeleteUsuarioCommand deleteUsuarioCommand;
    private Usuario usuario;
    private EraseUsuarioCommand eraseUsuarioCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        eraseUsuarioCommand = Mockito.mock(EraseUsuarioCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        deleteUsuarioCommand = new DeleteUsuarioCommand(usuario);
        deleteUsuarioCommand.setEraseUsuarioCommand(eraseUsuarioCommand);
        deleteUsuarioCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario erasedUsuario = new Usuario();
        when(eraseUsuarioCommand.getReturnParam()).thenReturn(erasedUsuario);

        // Act
        deleteUsuarioCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseUsuarioCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(erasedUsuario, deleteUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario result = new Usuario();

        // Act
        Usuario returnParam = deleteUsuarioCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
