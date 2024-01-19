package relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.AddRelacionCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.CreateRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateRelacionCommandTest {
    private CreateRelacionCommand createRelacionCommand;
    private Relacion_VA relacionVA;
    private AddRelacionCommand addRelacionCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        relacionVA = Mockito.mock(Relacion_VA.class);
        addRelacionCommand = Mockito.mock(AddRelacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        createRelacionCommand = new CreateRelacionCommand(relacionVA);
        createRelacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA expectedResult = Mockito.mock(Relacion_VA.class);
        when(addRelacionCommand.getReturnParam()).thenReturn(expectedResult);

        // Act
        createRelacionCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        verify(dbHandler,times(1)).beginTransaction();
        verify(addRelacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedResult, createRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Relacion_VA expectedResult = Mockito.mock(Relacion_VA.class);

        // Act
        Relacion_VA returnParam = createRelacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedResult, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
