package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.EraseZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseZonaCommandTest {
    private EraseZonaCommand eraseZonaCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private Zona_Segura zonaSegura;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        eraseZonaCommand = new EraseZonaCommand(zonaSegura, dbHandler);
        eraseZonaCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Zona_Segura deletedZonaSegura = new Zona_Segura();
        when(zonaSeguraDao.delete(zonaSegura)).thenReturn(deletedZonaSegura);

        // Act
        eraseZonaCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).delete(zonaSegura);
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(deletedZonaSegura, eraseZonaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
