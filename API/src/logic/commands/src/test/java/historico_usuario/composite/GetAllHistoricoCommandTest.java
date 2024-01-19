package historico_usuario.composite;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByListCommand;
import com.ucab.cmcapp.logic.commands.historico_usuario.composite.GetAllHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllHistoricoCommandTest {
    private GetAllHistoricoCommand getAllHistoricoCommand;
    private GetHistoricoByListCommand getHistoricoByListCommand;
    private DBHandler dbHandler;
    private List<Historico_Usuario> historicoUsuarioList;

    @BeforeEach
    public void setup() {
        getHistoricoByListCommand = Mockito.mock(GetHistoricoByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuarioList = new ArrayList<>();
        getAllHistoricoCommand = new GetAllHistoricoCommand();
        getAllHistoricoCommand.setHandler(dbHandler);
        getAllHistoricoCommand.setGetHistoricoByListCommand(getHistoricoByListCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Historico_Usuario> historicoUsuarioResult = new ArrayList<>();
        when(getHistoricoByListCommand.getReturnParam()).thenReturn(historicoUsuarioResult);

        // Act
        getAllHistoricoCommand.execute();

        // Assert
        verify(getHistoricoByListCommand,times(0)).execute();
        assertNotEquals(historicoUsuarioResult, getAllHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Historico_Usuario> result = new ArrayList<>();

        // Act
        List<Historico_Usuario> returnParam = getAllHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
