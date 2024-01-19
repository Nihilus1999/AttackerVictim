package relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByIdCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.GetRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetRelacionCommandTest {
    private GetRelacionCommand getRelacionCommand;
    private GetRelacionByIdCommand getRelacionByIdCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        getRelacionByIdCommand = Mockito.mock(GetRelacionByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getRelacionCommand = new GetRelacionCommand(new Relacion_VA());
        getRelacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA expectedResult = new Relacion_VA();
        when(getRelacionByIdCommand.getReturnParam()).thenReturn(expectedResult);

        // Act
        getRelacionCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        verify(dbHandler,times(0)).beginTransaction();
        verify(getRelacionByIdCommand,times(0)).execute();
        verify(dbHandler,times(0)).finishTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedResult, getRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Relacion_VA expectedResult = new Relacion_VA();

        // Act
        Relacion_VA returnParam = getRelacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedResult, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
