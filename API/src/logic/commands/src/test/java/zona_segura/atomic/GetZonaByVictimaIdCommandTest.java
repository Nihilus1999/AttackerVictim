package zona_segura.atomic;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByVictimaIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_SeguraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetZonaByVictimaIdCommandTest {
    private GetZonaByVictimaIdCommand getZonaByVictimaIdCommand;
    private Zona_SeguraDao zonaSeguraDao;
    private DBHandler dbHandler;
    private Zona_Segura zonaSegura;
    private List<Zona_Segura> zonaSeguraList;

    @BeforeEach
    public void setup() {
        zonaSegura = new Zona_Segura();
        zonaSeguraList = new ArrayList<>();
        dbHandler = Mockito.mock(DBHandler.class);
        zonaSeguraDao = Mockito.mock(Zona_SeguraDao.class);
        getZonaByVictimaIdCommand = new GetZonaByVictimaIdCommand(zonaSegura);
        getZonaByVictimaIdCommand.setHandler(dbHandler);
        getZonaByVictimaIdCommand.setDao(zonaSeguraDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(zonaSeguraDao.getZonaByVictimaId(zonaSegura.get_victima())).thenReturn(zonaSeguraList);

        // Act
        getZonaByVictimaIdCommand.execute();

        // Assert
        verify(zonaSeguraDao,times(0)).getZonaByVictimaId(zonaSegura.get_victima());
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(zonaSeguraList, getZonaByVictimaIdCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getZonaByVictimaIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }


}
