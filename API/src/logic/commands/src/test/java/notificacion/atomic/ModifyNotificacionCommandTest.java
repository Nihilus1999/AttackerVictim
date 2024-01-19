package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.ModifyNotificacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyNotificacionCommandTest {
    private ModifyNotificacionCommand modifyNotificacionCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        modifyNotificacionCommand = new ModifyNotificacionCommand(new Notificacion(), dbHandler);
        modifyNotificacionCommand.setDao(notificacionDao);
        modifyNotificacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();
        when(notificacionDao.update(any())).thenReturn(expectedNotificacion);

        // Act
        modifyNotificacionCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).update(any());
        assertNotEquals(expectedNotificacion, modifyNotificacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Notificacion expectedNotificacion = new Notificacion();

        // Act
        Notificacion returnParam = modifyNotificacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedNotificacion, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyNotificacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
