package zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.EraseZonaCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.DeleteZonaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteZonaCommandTest {
    private DeleteZonaCommand deleteZonaCommand;
    private Zona_Segura zonaSegura;
    private EraseZonaCommand eraseZonaCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        eraseZonaCommand = Mockito.mock(EraseZonaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        deleteZonaCommand = new DeleteZonaCommand(zonaSegura);
        deleteZonaCommand.setEraseZonaCommand(eraseZonaCommand);
        deleteZonaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        Zona_Segura expectedZonaSegura = new Zona_Segura();
        when(eraseZonaCommand.getReturnParam()).thenReturn(expectedZonaSegura);

        // Act
        deleteZonaCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseZonaCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedZonaSegura, deleteZonaCommand.getReturnParam());
    }

    @Test
    public void testExecute_Exception() {
        // Arrange
        RuntimeException exception = new RuntimeException("Test Exception");
        when(eraseZonaCommand.getReturnParam()).thenThrow(exception);

        // Act & Assert
        verify(dbHandler,times(0)).beginTransaction();
        verify(eraseZonaCommand,times(0)).execute();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
