package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.NotificacionDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetNotificacionByListCommandTest {
    private GetNotificacionByListCommand getNotificacionByListCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getNotificacionByListCommand = new GetNotificacionByListCommand(dbHandler);
        getNotificacionByListCommand.setDao(notificacionDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Notificacion> expectedList = new ArrayList<>();
        expectedList.add(new Notificacion());
        when(notificacionDao.findAll(Notificacion.class)).thenReturn(expectedList);

        // Act
        getNotificacionByListCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).findAll(Notificacion.class);
        assertNotEquals(expectedList, getNotificacionByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Notificacion> expectedList = new ArrayList<>();

        // Act
        List<Notificacion> returnParam = getNotificacionByListCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getNotificacionByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
