package relacion_VA.composite;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.EraseRelacionCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.DeleteRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class DeleteRelacionCommandTest {
    private DeleteRelacionCommand deleteRelacionCommand;
    private Relacion_VA relacionVA;
    private EraseRelacionCommand eraseRelacionCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        relacionVA = Mockito.mock(Relacion_VA.class);
        eraseRelacionCommand = Mockito.mock(EraseRelacionCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        deleteRelacionCommand = new DeleteRelacionCommand(relacionVA);
        deleteRelacionCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA expectedResult = Mockito.mock(Relacion_VA.class);
        when(eraseRelacionCommand.getReturnParam()).thenReturn(expectedResult);


        // Act
        deleteRelacionCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseRelacionCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedResult, deleteRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Relacion_VA expectedResult = Mockito.mock(Relacion_VA.class);

        // Act
        Relacion_VA returnParam = deleteRelacionCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedResult, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
