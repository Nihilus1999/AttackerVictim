package zona_segura.composite;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.ModifyZonaCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.UpdateZonaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateZonaCommandTest {
    private UpdateZonaCommand updateZonaCommand;
    private ModifyZonaCommand modifyZonaCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        modifyZonaCommand = Mockito.mock(ModifyZonaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        updateZonaCommand = new UpdateZonaCommand(new Zona_Segura());
        updateZonaCommand.setModifyZonaCommand(modifyZonaCommand);
        updateZonaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        Zona_Segura expectedZonaSegura = new Zona_Segura();
        when(modifyZonaCommand.getReturnParam()).thenReturn(expectedZonaSegura);

        // Act
        updateZonaCommand.execute();

        // Assert
        verify(modifyZonaCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler, never()).rollbackTransaction();
        verify(dbHandler, times(1)).closeSession();
        assertNotEquals(expectedZonaSegura, updateZonaCommand.getReturnParam());
    }

    @Test
    public void testExecute_Exception() {
        // Arrange
        RuntimeException exception = new RuntimeException("Test Exception");
        when(modifyZonaCommand.getReturnParam()).thenThrow(exception);

        // Act & Assert
        verify(modifyZonaCommand,times(0)).execute();
        verify(dbHandler,times(0)).beginTransaction();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
