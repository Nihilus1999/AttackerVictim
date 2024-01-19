package historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.EraseHistoricoCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.DeleteHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteHistoricoCommandTest {
    private DeleteHistoricoCommand deleteHistoricoCommand;
    private EraseHistoricoCommand eraseHistoricoCommand;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;

    @BeforeEach
    public void setup() {
        eraseHistoricoCommand = Mockito.mock(EraseHistoricoCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        deleteHistoricoCommand = new DeleteHistoricoCommand(historicoUsuario);
        deleteHistoricoCommand.setHandler(dbHandler);
        deleteHistoricoCommand.setEraseHistoricoCommand(eraseHistoricoCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario historicoUsuarioResult = new Historico_Usuario();
        when(eraseHistoricoCommand.getReturnParam()).thenReturn(historicoUsuarioResult);

        // Act
        deleteHistoricoCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseHistoricoCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(historicoUsuarioResult, deleteHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();

        // Act
        Historico_Usuario returnParam = deleteHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
