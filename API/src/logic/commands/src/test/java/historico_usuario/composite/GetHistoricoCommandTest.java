package historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByIdCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.GetHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetHistoricoCommandTest {
    private GetHistoricoCommand getHistoricoCommand;
    private GetHistoricoByIdCommand getHistoricoByIdCommand;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;
    private long id;

    @BeforeEach
    public void setup() {
        getHistoricoByIdCommand = Mockito.mock(GetHistoricoByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        id = historicoUsuario.get_id();
        getHistoricoCommand = new GetHistoricoCommand(historicoUsuario);
        getHistoricoCommand.setHandler(dbHandler);
        getHistoricoCommand.setGetHistoricoByIdCommand(getHistoricoByIdCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario historicoUsuarioResult = new Historico_Usuario();
        when(getHistoricoByIdCommand.getReturnParam()).thenReturn(historicoUsuarioResult);

        // Act
        getHistoricoCommand.execute();

        // Assert
        verify(getHistoricoByIdCommand,times(0)).execute();
        assertNotEquals(historicoUsuarioResult, getHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();

        // Act
        Historico_Usuario returnParam = getHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
