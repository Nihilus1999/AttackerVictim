package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetCoordenadaByListCommandTest {
    private GetCoordenadaByListCommand getCoordenadaByListCommand;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getCoordenadaByListCommand = new GetCoordenadaByListCommand(dbHandler);
        getCoordenadaByListCommand.setHandler(dbHandler);
        getCoordenadaByListCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Coordenada> result = new ArrayList<>();
        when(coordenadaDao.findAll(Coordenada.class)).thenReturn(result);

        // Act
        getCoordenadaByListCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).findAll(Coordenada.class);
        assertNotEquals(result, getCoordenadaByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Coordenada> result = new ArrayList<>();

        // Act
        List<Coordenada> returnParam = getCoordenadaByListCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getCoordenadaByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
