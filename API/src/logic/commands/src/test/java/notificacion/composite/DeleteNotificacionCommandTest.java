package notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.EraseNotificacionCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.DeleteNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteNotificacionCommandTest {
    private DeleteNotificacionCommand deleteNotificacionCommand;
    private EraseNotificacionCommand eraseNotificacionCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        eraseNotificacionCommand = Mockito.mock(EraseNotificacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        deleteNotificacionCommand = new DeleteNotificacionCommand(new Notificacion());
        deleteNotificacionCommand.setHandler(dbHandler);
        deleteNotificacionCommand.setEraseNotificacionCommand(eraseNotificacionCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(eraseNotificacionCommand.getReturnParam()).thenReturn(expectedNotificacion);

        // Act
        deleteNotificacionCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseNotificacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedNotificacion, deleteNotificacionCommand.getReturnParam());
    }

    @Test
    public void testExecuteWithException() throws Exception {
        // Arrange
        doThrow(new RuntimeException()).when(eraseNotificacionCommand).execute();

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
        Notificacion returnParam = deleteNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
