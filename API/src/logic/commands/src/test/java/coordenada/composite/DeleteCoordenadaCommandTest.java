package coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.EraseCoordenadaCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.DeleteCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteCoordenadaCommandTest {
    private DeleteCoordenadaCommand deleteCoordenadaCommand;
    private EraseCoordenadaCommand eraseCoordenadaCommand;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        eraseCoordenadaCommand = Mockito.mock(EraseCoordenadaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        deleteCoordenadaCommand = new DeleteCoordenadaCommand(coordenada);
        deleteCoordenadaCommand.setHandler(dbHandler);
        deleteCoordenadaCommand.setEraseCoordenadaCommand(eraseCoordenadaCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada erasedCoordenada = new Coordenada();
        when(eraseCoordenadaCommand.getReturnParam()).thenReturn(erasedCoordenada);

        // Act
        deleteCoordenadaCommand.execute();

        // Assert
        verify(eraseCoordenadaCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(erasedCoordenada, deleteCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = deleteCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
