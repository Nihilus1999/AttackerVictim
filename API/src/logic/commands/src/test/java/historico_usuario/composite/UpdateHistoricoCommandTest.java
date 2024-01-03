package historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.ModifyHistoricoCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.UpdateHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateHistoricoCommandTest {
    private UpdateHistoricoCommand updateHistoricoCommand;
    private ModifyHistoricoCommand modifyHistoricoCommand;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;
    private Historico_Usuario result;

    @BeforeEach
    public void setup() {
        modifyHistoricoCommand = Mockito.mock(ModifyHistoricoCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        result = new Historico_Usuario();
        updateHistoricoCommand = new UpdateHistoricoCommand(historicoUsuario);
        updateHistoricoCommand.setHandler(dbHandler);
        updateHistoricoCommand.setModifyHistoricoCommand(modifyHistoricoCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(modifyHistoricoCommand.getReturnParam()).thenReturn(result);

        // Act
        updateHistoricoCommand.execute();

        // Assert
        verify(modifyHistoricoCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(result, updateHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange

        // Act
        Historico_Usuario returnParam = updateHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
