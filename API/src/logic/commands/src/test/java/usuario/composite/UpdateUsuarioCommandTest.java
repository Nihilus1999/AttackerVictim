package usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.ModifyUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UpdateUsuarioCommandTest {
    private UpdateUsuarioCommand updateUsuarioCommand;
    private Usuario usuario;
    private ModifyUsuarioCommand modifyUsuarioCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        modifyUsuarioCommand = Mockito.mock(ModifyUsuarioCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        updateUsuarioCommand = new UpdateUsuarioCommand(usuario);
        updateUsuarioCommand.setHandler(dbHandler);
        updateUsuarioCommand.setModifyUsuarioCommand(modifyUsuarioCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Usuario modifiedUsuario = new Usuario();
        when(modifyUsuarioCommand.getReturnParam()).thenReturn(modifiedUsuario);

        // Act
        updateUsuarioCommand.execute();

        // Assert
        verify(modifyUsuarioCommand,times(0)).execute();
        assertNotEquals(modifiedUsuario, updateUsuarioCommand.getReturnParam());
        verify(dbHandler).finishTransaction();
        verify(dbHandler).closeSession();
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario result = new Usuario();

        // Act
        Usuario returnParam = updateUsuarioCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}