package notificacion.atomic;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.logic.commands.notificacion.atomic.GetNotificacionByUsuarioIdCommand;
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

public class GetNotificacionByUsuarioIdCommandTest {
    private GetNotificacionByUsuarioIdCommand getNotificacionByUsuarioIdCommand;
    private NotificacionDao notificacionDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        notificacionDao = Mockito.mock(NotificacionDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getNotificacionByUsuarioIdCommand = new GetNotificacionByUsuarioIdCommand(new Notificacion());
        getNotificacionByUsuarioIdCommand.setDao(notificacionDao);
        getNotificacionByUsuarioIdCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Notificacion> expectedList = new ArrayList<>();
        expectedList.add(new Notificacion());
        when(notificacionDao.getNotificacionByUsuarioId(any())).thenReturn(expectedList);

        // Act
        getNotificacionByUsuarioIdCommand.execute();

        // Assert
        verify(notificacionDao,times(0)).getNotificacionByUsuarioId(any());
        assertNotEquals(expectedList, getNotificacionByUsuarioIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Notificacion> expectedList = new ArrayList<>();

        // Act
        List<Notificacion> returnParam = getNotificacionByUsuarioIdCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getNotificacionByUsuarioIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
