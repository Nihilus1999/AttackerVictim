package notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByIdCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.GetNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetNotificacionCommandTest {
    private GetNotificacionCommand getNotificacionCommand;
    private GetNotificacionByIdCommand getNotificacionByIdCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getNotificacionByIdCommand = Mockito.mock(GetNotificacionByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getNotificacionCommand = new GetNotificacionCommand(new Notificacion());
        getNotificacionCommand.setHandler(dbHandler);
        getNotificacionCommand.setGetNotificacionByIdCommand(getNotificacionByIdCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(getNotificacionByIdCommand.getReturnParam()).thenReturn(expectedNotificacion);

        // Act
        getNotificacionCommand.execute();

        // Assert
        verify(getNotificacionByIdCommand,times(0)).execute();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedNotificacion, getNotificacionCommand.getReturnParam());
    }

    @Test
    public void testExecuteWithException() throws Exception {
        // Arrange
        doThrow(new RuntimeException()).when(getNotificacionByIdCommand).execute();

        // Act & Assert
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = getNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}