package coordenada.atomic;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByZonaIdCommand;
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

public class GetCoordenadaByZonaIdCommandTest {
    private GetCoordenadaByZonaIdCommand getCoordenadaByZonaIdCommand;
    private CoordenadaDao coordenadaDao;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        coordenadaDao = Mockito.mock(CoordenadaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        getCoordenadaByZonaIdCommand = new GetCoordenadaByZonaIdCommand(coordenada);
        getCoordenadaByZonaIdCommand.setHandler(dbHandler);
        getCoordenadaByZonaIdCommand.setCoordenadaDao(coordenadaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Coordenada> result = new ArrayList<>();
        when(coordenadaDao.getCoordenadaByZonaId(coordenada.get_zona_segura())).thenReturn(result);

        // Act
        getCoordenadaByZonaIdCommand.execute();

        // Assert
        verify(coordenadaDao,times(0)).getCoordenadaByZonaId(coordenada.get_zona_segura());
        assertNotEquals(result, getCoordenadaByZonaIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Coordenada> result = new ArrayList<>();

        // Act
        List<Coordenada> returnParam = getCoordenadaByZonaIdCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getCoordenadaByZonaIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
