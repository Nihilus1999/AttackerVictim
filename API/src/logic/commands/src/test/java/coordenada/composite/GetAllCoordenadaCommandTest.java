package coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByListCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.GetAllCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllCoordenadaCommandTest {
    private GetAllCoordenadaCommand getAllCoordenadaCommand;
    private GetCoordenadaByListCommand getCoordenadaByListCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getCoordenadaByListCommand = Mockito.mock(GetCoordenadaByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAllCoordenadaCommand = new GetAllCoordenadaCommand();
        getAllCoordenadaCommand.setHandler(dbHandler);
        getAllCoordenadaCommand.setGetCoordenadaByListCommand(getCoordenadaByListCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Coordenada> coordenadaList = new ArrayList<>();
        when(getCoordenadaByListCommand.getReturnParam()).thenReturn(coordenadaList);

        // Act
        getAllCoordenadaCommand.execute();

        // Assert
        verify(getCoordenadaByListCommand,times(0)).execute();
        verify(dbHandler,times(0)).beginTransaction();
        verify(dbHandler,times(0)).finishTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(coordenadaList, getAllCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Coordenada> result = new ArrayList<>();

        // Act
        List<Coordenada> returnParam = getAllCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
