package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.EraseCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseCoordenadaCommandTest {
    private EraseCoordenadaCommand eraseCoordenadaCommand;
    private Coordenada coordenada;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        coordenada = new Coordenada();
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        eraseCoordenadaCommand = new EraseCoordenadaCommand(coordenada, dbHandler);
        eraseCoordenadaCommand.setHandler(dbHandler);
        eraseCoordenadaCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada result = new Coordenada();
        when(coordenadaDao.delete(coordenada)).thenReturn(result);

        // Act
        eraseCoordenadaCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).delete(coordenada);
        assertNotEquals(result, eraseCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = eraseCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
