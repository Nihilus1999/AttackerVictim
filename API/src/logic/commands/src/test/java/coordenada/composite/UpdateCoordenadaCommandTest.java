package coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.ModifyCoordenadaCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.UpdateCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateCoordenadaCommandTest {
    private UpdateCoordenadaCommand updateCoordenadaCommand;
    private ModifyCoordenadaCommand modifyCoordenadaCommand;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        modifyCoordenadaCommand = Mockito.mock(ModifyCoordenadaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        updateCoordenadaCommand = new UpdateCoordenadaCommand(coordenada);
        updateCoordenadaCommand.setHandler(dbHandler);
        updateCoordenadaCommand.setModifyCoordenadaCommand(modifyCoordenadaCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada coordenadaResult = new Coordenada();
        when(modifyCoordenadaCommand.getReturnParam()).thenReturn(coordenadaResult);

        // Act
        updateCoordenadaCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(modifyCoordenadaCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(coordenadaResult, updateCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = updateCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
