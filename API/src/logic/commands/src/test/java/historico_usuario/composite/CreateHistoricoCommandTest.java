package historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.AddHistoricoCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.CreateHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateHistoricoCommandTest {
    private CreateHistoricoCommand createHistoricoCommand;
    private AddHistoricoCommand addHistoricoCommand;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;
    private Logger logger;

    @BeforeEach
    public void setup() {
        addHistoricoCommand = Mockito.mock(AddHistoricoCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        logger = Mockito.mock(Logger.class);
        createHistoricoCommand = new CreateHistoricoCommand(historicoUsuario);
        createHistoricoCommand.setHandler(dbHandler);
        createHistoricoCommand.setAddHistoricoCommand(addHistoricoCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario historicoUsuarioResult = new Historico_Usuario();
        when(addHistoricoCommand.getReturnParam()).thenReturn(historicoUsuarioResult);

        // Act
        createHistoricoCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(addHistoricoCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(historicoUsuarioResult, createHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();

        // Act
        Historico_Usuario returnParam = createHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
