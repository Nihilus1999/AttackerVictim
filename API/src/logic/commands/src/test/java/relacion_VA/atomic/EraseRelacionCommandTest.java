package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.EraseRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseRelacionCommandTest {
    private EraseRelacionCommand eraseRelacionCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;
    private Relacion_VA relacionVA;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        relacionVA = new Relacion_VA();
        eraseRelacionCommand = new EraseRelacionCommand(relacionVA, dbHandler);
        eraseRelacionCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA deletedRelacionVA = new Relacion_VA();
        when(relacionVADao.delete(relacionVA)).thenReturn(deletedRelacionVA);

        // Act
        eraseRelacionCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).delete(relacionVA);
        assertNotEquals(deletedRelacionVA, relacionVA);
    }

    @Test
    public void testGetReturnParam() {
        // Arrange

        // Act
        Relacion_VA returnParam = eraseRelacionCommand.getReturnParam();

        // Assert
        assertEquals(relacionVA, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
