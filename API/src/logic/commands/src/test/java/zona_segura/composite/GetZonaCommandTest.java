package zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByIdCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.GetZonaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class GetZonaCommandTest {
    private GetZonaCommand getZonaCommand;
    private GetZonaByIdCommand getZonaByIdCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getZonaByIdCommand = Mockito.mock(GetZonaByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getZonaCommand = new GetZonaCommand(new Zona_Segura());
        getZonaCommand.setGetZonaByIdCommand(getZonaByIdCommand);
        getZonaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        Zona_Segura expectedZonaSegura = new Zona_Segura();
        when(getZonaByIdCommand.getReturnParam()).thenReturn(expectedZonaSegura);

        // Act
        getZonaCommand.execute();

        // Assert
        verify(getZonaByIdCommand,never()).execute();
        verify(dbHandler, never()).rollbackTransaction();
        verify(dbHandler, never()).closeSession();
        assertNotEquals(expectedZonaSegura, getZonaCommand.getReturnParam());
    }

    @Test
    public void testExecute_Exception() {
        // Arrange
        RuntimeException exception = new RuntimeException("Test Exception");
        when(getZonaByIdCommand.getReturnParam()).thenThrow(exception);

        // Act & Assert
        verify(getZonaByIdCommand,times(0)).execute();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
