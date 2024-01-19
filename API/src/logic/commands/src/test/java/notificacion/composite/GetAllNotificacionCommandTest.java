package notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByListCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.GetAllNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllNotificacionCommandTest {
    private GetAllNotificacionCommand getAllNotificacionCommand;
    private GetNotificacionByListCommand getNotificacionByListCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getNotificacionByListCommand = Mockito.mock(GetNotificacionByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAllNotificacionCommand = new GetAllNotificacionCommand();
        getAllNotificacionCommand.setHandler(dbHandler);
        getAllNotificacionCommand.setGetNotificacionByListCommand(getNotificacionByListCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        List<Notificacion> expectedNotificaciones = new ArrayList<>();
        expectedNotificaciones.add(new Notificacion());
        when(getNotificacionByListCommand.getReturnParam()).thenReturn(expectedNotificaciones);

        // Act
        getAllNotificacionCommand.execute();

        // Assert
        verify(getNotificacionByListCommand,times(0)).execute();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedNotificaciones, getAllNotificacionCommand.getReturnParam());
    }

    @Test
    public void testExecuteWithException() throws Exception {
        // Arrange
        doThrow(new RuntimeException()).when(getNotificacionByListCommand).execute();

        // Act & Assert
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Notificacion> expectedNotificaciones = new ArrayList<>();

        // Act
        List<Notificacion> returnParam = getAllNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificaciones, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
