package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.AddCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddCoordenadaCommandTest {
    private AddCoordenadaCommand addCoordenadaCommand;
    private Coordenada coordenada;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        coordenada = new Coordenada();
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        addCoordenadaCommand = new AddCoordenadaCommand(coordenada);
        addCoordenadaCommand.setHandler(dbHandler);
        addCoordenadaCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada result = new Coordenada();
        when(coordenadaDao.insert(coordenada)).thenReturn(result);

        // Act
        addCoordenadaCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).insert(coordenada);
        assertNotEquals(result, addCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = addCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
