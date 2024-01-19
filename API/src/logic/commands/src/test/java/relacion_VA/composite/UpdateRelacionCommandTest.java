package relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.ModifyRelacionCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.UpdateRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateRelacionCommandTest {
    private UpdateRelacionCommand updateRelacionCommand;
    private ModifyRelacionCommand modifyRelacionCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        modifyRelacionCommand = Mockito.mock(ModifyRelacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        updateRelacionCommand = new UpdateRelacionCommand(new Relacion_VA());
        updateRelacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA expectedResult = new Relacion_VA();
        when(modifyRelacionCommand.getReturnParam()).thenReturn(expectedResult);

        // Act
        updateRelacionCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        verify(dbHandler,times(1)).beginTransaction();
        verify(modifyRelacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedResult, updateRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Relacion_VA expectedResult = new Relacion_VA();

        // Act
        Relacion_VA returnParam = updateRelacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedResult, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
