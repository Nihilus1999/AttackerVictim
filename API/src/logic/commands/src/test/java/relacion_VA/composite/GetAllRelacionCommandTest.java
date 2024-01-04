package relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByListCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.GetAllRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllRelacionCommandTest {
    private GetAllRelacionCommand getAllRelacionCommand;
    private GetRelacionByListCommand getRelacionByListCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        getRelacionByListCommand = Mockito.mock(GetRelacionByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAllRelacionCommand = new GetAllRelacionCommand();
        getAllRelacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Relacion_VA> expectedResult = new ArrayList<>();
        when(getRelacionByListCommand.getReturnParam()).thenReturn(expectedResult);

        // Act
        getAllRelacionCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        verify(dbHandler,times(0)).beginTransaction();
        verify(getRelacionByListCommand,times(0)).execute();
        verify(dbHandler,times(0)).finishTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedResult, getAllRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Relacion_VA> expectedResult = new ArrayList<>();

        // Act
        List<Relacion_VA> returnParam = getAllRelacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedResult, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
