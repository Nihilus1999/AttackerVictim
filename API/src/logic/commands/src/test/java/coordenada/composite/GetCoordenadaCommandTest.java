package coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByIdCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.GetCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetCoordenadaCommandTest {
    private GetCoordenadaCommand getCoordenadaCommand;
    private GetCoordenadaByIdCommand getCoordenadaByIdCommand;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        getCoordenadaByIdCommand = Mockito.mock(GetCoordenadaByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        getCoordenadaCommand = new GetCoordenadaCommand(coordenada);
        getCoordenadaCommand.setHandler(dbHandler);
        getCoordenadaCommand.setGetCoordenadaByIdCommand(getCoordenadaByIdCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada coordenadaResult = new Coordenada();
        when(getCoordenadaByIdCommand.getReturnParam()).thenReturn(coordenadaResult);

        // Act
        getCoordenadaCommand.execute();

        // Assert
        verify(getCoordenadaByIdCommand,times(0)).execute();
        verify(dbHandler,times(0)).beginTransaction();
        verify(dbHandler,times(0)).finishTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(coordenadaResult, getCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = getCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
