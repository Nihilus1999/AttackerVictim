package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.EraseNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseNotificacionCommandTest {
    private EraseNotificacionCommand eraseNotificacionCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        eraseNotificacionCommand = new EraseNotificacionCommand(new Notificacion(), dbHandler);
        eraseNotificacionCommand.setDao(notificacionDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(notificacionDao.delete(expectedNotificacion)).thenReturn(expectedNotificacion);

        // Act
        eraseNotificacionCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).delete(expectedNotificacion);
        assertNotEquals(expectedNotificacion, eraseNotificacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = eraseNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
