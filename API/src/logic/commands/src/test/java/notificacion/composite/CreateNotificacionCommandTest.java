package notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.AddNotificacionCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.CreateNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateNotificacionCommandTest {
    private CreateNotificacionCommand createNotificacionCommand;
    private AddNotificacionCommand addNotificacionCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        addNotificacionCommand = Mockito.mock(AddNotificacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        createNotificacionCommand = new CreateNotificacionCommand(new Notificacion());
        createNotificacionCommand.setHandler(dbHandler);
        createNotificacionCommand.setAddNotificacionCommand(addNotificacionCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(addNotificacionCommand.getReturnParam()).thenReturn(expectedNotificacion);

        // Act
        createNotificacionCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(addNotificacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedNotificacion, createNotificacionCommand.getReturnParam());
    }

    @Test
    public void testExecuteWithException() throws Exception {
        // Arrange
        doThrow(new RuntimeException()).when(addNotificacionCommand).execute();

        // Act & Assert
        verify(dbHandler,times(0)).beginTransaction();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = createNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}