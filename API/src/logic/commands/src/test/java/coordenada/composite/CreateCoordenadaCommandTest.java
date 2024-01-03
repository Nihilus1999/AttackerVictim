package coordenada.composite;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.AddCoordenadaCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.CreateCoordenadaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateCoordenadaCommandTest {
    private CreateCoordenadaCommand createCoordenadaCommand;
    private AddCoordenadaCommand addCoordenadaCommand;
    private DBHandler dbHandler;
    private Coordenada coordenada;

    @BeforeEach
    public void setup() {
        addCoordenadaCommand = Mockito.mock(AddCoordenadaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        coordenada = new Coordenada();
        createCoordenadaCommand = new CreateCoordenadaCommand(coordenada);
        createCoordenadaCommand.setHandler(dbHandler);
        createCoordenadaCommand.setAddCoordenadaCommand(addCoordenadaCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Coordenada createdCoordenada = new Coordenada();
        when(addCoordenadaCommand.getReturnParam()).thenReturn(createdCoordenada);

        // Act
        createCoordenadaCommand.execute();

        // Assert
        verify(addCoordenadaCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(createdCoordenada, createCoordenadaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Coordenada result = new Coordenada();

        // Act
        Coordenada returnParam = createCoordenadaCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createCoordenadaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}