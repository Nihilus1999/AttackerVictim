package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByIdCommand;
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

public class GetCoordenadaByIdCommandTest {
    private GetCoordenadaByIdCommand getCoordenadaByIdCommand;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;
    private Logger logger;
    private long userId;

    @BeforeEach
    public void setup() {
        userId = 12345L;
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getCoordenadaByIdCommand = new GetCoordenadaByIdCommand(dbHandler, userId);
        getCoordenadaByIdCommand.setHandler(dbHandler);
        getCoordenadaByIdCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada result = new Coordenada();
        when(coordenadaDao.find(userId, Coordenada.class)).thenReturn(result);

        // Act
        getCoordenadaByIdCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).find(userId, Coordenada.class);
        assertNotEquals(result, getCoordenadaByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = getCoordenadaByIdCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getCoordenadaByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
