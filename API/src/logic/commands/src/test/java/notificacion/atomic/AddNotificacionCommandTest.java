package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.AddNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddNotificacionCommandTest {
    private AddNotificacionCommand addNotificacionCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        addNotificacionCommand = new AddNotificacionCommand(new Notificacion(), dbHandler);
        addNotificacionCommand.setDao(notificacionDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(notificacionDao.insert(expectedNotificacion)).thenReturn(expectedNotificacion);

        // Act
        addNotificacionCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).insert(expectedNotificacion);
        assertNotEquals(expectedNotificacion, addNotificacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = addNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
