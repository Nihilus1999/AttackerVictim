package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetZonaByListCommandTest {
    private GetZonaByListCommand getZonaByListCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private List<Zona_Segura> zonaSeguraList;

    @BeforeEach
    public void setup() {
        zonaSeguraList = new ArrayList<>();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        getZonaByListCommand = new GetZonaByListCommand(dbHandler);
        getZonaByListCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(zonaSeguraDao.findAll(Zona_Segura.class)).thenReturn(zonaSeguraList);

        // Act
        getZonaByListCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).findAll(Zona_Segura.class);
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(zonaSeguraList, getZonaByListCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getZonaByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }


}