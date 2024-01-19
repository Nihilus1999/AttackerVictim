package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByIdCommand;
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

public class GetNotificacionByIdCommandTest {
    private GetNotificacionByIdCommand getNotificacionByIdCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getNotificacionByIdCommand = new GetNotificacionByIdCommand(dbHandler, 1);
        getNotificacionByIdCommand.setDao(notificacionDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        getNotificacionByIdCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).find(1L, Notificacion.class);
        assertNotEquals(expectedNotificacion, getNotificacionByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = getNotificacionByIdCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getNotificacionByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
