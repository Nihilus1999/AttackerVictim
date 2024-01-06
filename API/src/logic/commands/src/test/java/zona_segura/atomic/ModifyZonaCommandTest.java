package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.ModifyZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyZonaCommandTest {
    private ModifyZonaCommand modifyZonaCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private Zona_Segura zonaSegura;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        modifyZonaCommand = new ModifyZonaCommand(zonaSegura, dbHandler);
        modifyZonaCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(zonaSeguraDao.update(zonaSegura)).thenReturn(zonaSegura);

        // Act
        modifyZonaCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).update(zonaSegura);
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler, never()).closeSession();
        assertEquals(zonaSegura, modifyZonaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyZonaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
