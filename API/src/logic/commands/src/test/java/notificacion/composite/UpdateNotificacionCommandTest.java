package notificacion.composite;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.ModifyNotificacionCommand;
import com.ucab.cmcapp.logic.commands.notificacion.composite.UpdateNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateNotificacionCommandTest {
    private UpdateNotificacionCommand updateNotificacionCommand;
    private ModifyNotificacionCommand modifyNotificacionCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        modifyNotificacionCommand = Mockito.mock(ModifyNotificacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        updateNotificacionCommand = new UpdateNotificacionCommand(new Notificacion());
        updateNotificacionCommand.setHandler(dbHandler);
        updateNotificacionCommand.setModifyNotificacionCommand(modifyNotificacionCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(modifyNotificacionCommand.getReturnParam()).thenReturn(expectedNotificacion);

        // Act
        updateNotificacionCommand.execute();

        // Assert
        verify(modifyNotificacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedNotificacion, updateNotificacionCommand.getReturnParam());
    }

    @Test
    public void testExecuteWithException() throws Exception {
        // Arrange
        doThrow(new RuntimeException()).when(modifyNotificacionCommand).execute();

        // Act & Assert
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = updateNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
