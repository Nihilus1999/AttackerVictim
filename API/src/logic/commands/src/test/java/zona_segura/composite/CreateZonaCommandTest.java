package zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.AddZonaCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.CreateZonaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateZonaCommandTest {
    private CreateZonaCommand createZonaCommand;
    private Zona_Segura zonaSegura;
    private AddZonaCommand addZonaCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        addZonaCommand = Mockito.mock(AddZonaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        createZonaCommand = new CreateZonaCommand(zonaSegura);
        createZonaCommand.setAddZonaCommand(addZonaCommand);
        createZonaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        Zona_Segura expectedZonaSegura = new Zona_Segura();
        when(addZonaCommand.getReturnParam()).thenReturn(expectedZonaSegura);

        // Act
        createZonaCommand.execute();

        // Assert
        verify(addZonaCommand,never()).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedZonaSegura, createZonaCommand.getReturnParam());
    }

    @Test
    public void testExecute_Exception() {
        // Arrange
        RuntimeException exception = new RuntimeException("Test Exception");
        when(addZonaCommand.getReturnParam()).thenThrow(exception);

        // Act & Assert
        verify(dbHandler,never()).beginTransaction();
        verify(addZonaCommand,never()).execute();
        verify(dbHandler,never()).rollbackTransaction();
        verify(dbHandler,never()).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
