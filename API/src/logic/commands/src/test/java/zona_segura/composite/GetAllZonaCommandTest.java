package zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByListCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.GetAllZonaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllZonaCommandTest {
    private GetAllZonaCommand getAllZonaCommand;
    private GetZonaByListCommand getZonaByListCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getZonaByListCommand = Mockito.mock(GetZonaByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAllZonaCommand = new GetAllZonaCommand();
        getAllZonaCommand.setGetZonaByListCommand(getZonaByListCommand);
        getAllZonaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        List<Zona_Segura> expectedZonaSeguraList = new ArrayList<>();
        expectedZonaSeguraList.add(new Zona_Segura());
        when(getZonaByListCommand.getReturnParam()).thenReturn(expectedZonaSeguraList);

        // Act
        getAllZonaCommand.execute();

        // Assert
        verify(getZonaByListCommand,times(0)).execute();
        verify(dbHandler, never()).rollbackTransaction();
        verify(dbHandler, never()).closeSession();
        assertNotEquals(expectedZonaSeguraList, getAllZonaCommand.getReturnParam());
    }

    @Test
    public void testExecute_Exception() {
        // Arrange
        RuntimeException exception = new RuntimeException("Test Exception");
        when(getZonaByListCommand.getReturnParam()).thenThrow(exception);

        // Act & Assert
        verify(getZonaByListCommand,times(0)).execute();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
