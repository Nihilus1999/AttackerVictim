package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.AddZonaCommand;
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

public class AddZonaCommandTest {
    private AddZonaCommand addZonaCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private Zona_Segura zonaSegura;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        addZonaCommand = new AddZonaCommand(zonaSegura, dbHandler);
        addZonaCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Zona_Segura insertedZonaSegura = new Zona_Segura();
        when(zonaSeguraDao.insert(zonaSegura)).thenReturn(insertedZonaSegura);

        // Act
        addZonaCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).insert(zonaSegura);
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler, never()).closeSession();
        assertNotEquals(insertedZonaSegura, addZonaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
