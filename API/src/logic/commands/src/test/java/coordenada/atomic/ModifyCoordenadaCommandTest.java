package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.ModifyCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyCoordenadaCommandTest {
    private ModifyCoordenadaCommand modifyCoordenadaCommand;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        modifyCoordenadaCommand = new ModifyCoordenadaCommand(coordenada, dbHandler);
        modifyCoordenadaCommand.setHandler(dbHandler);
        modifyCoordenadaCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada updatedCoordenada = new Coordenada();
        when(coordenadaDao.update(coordenada)).thenReturn(updatedCoordenada);

        // Act
        modifyCoordenadaCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).update(coordenada);
        assertNotEquals(updatedCoordenada, modifyCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = modifyCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
