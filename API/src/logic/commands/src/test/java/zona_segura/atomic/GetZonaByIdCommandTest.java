package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetZonaByIdCommandTest {
    private GetZonaByIdCommand getZonaByIdCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private Zona_Segura zonaSegura;
    private long userId;

    @BeforeEach
    public void setup() {
        userId = 123L;
        zonaSegura = new Zona_Segura();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        getZonaByIdCommand = new GetZonaByIdCommand(dbHandler, userId);
        getZonaByIdCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(zonaSeguraDao.find(userId, Zona_Segura.class)).thenReturn(zonaSegura);

        // Act
        getZonaByIdCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).find(userId, Zona_Segura.class);
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(zonaSegura, getZonaByIdCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getZonaByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
