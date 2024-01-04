package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.ModifyRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyRelacionCommandTest {
    private ModifyRelacionCommand modifyRelacionCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;
    private Relacion_VA relacionVA;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        relacionVA = Mockito.mock(Relacion_VA.class);
        modifyRelacionCommand = new ModifyRelacionCommand(relacionVA, dbHandler);
        modifyRelacionCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA updatedRelacionVA = Mockito.mock(Relacion_VA.class);
        when(relacionVADao.update(relacionVA)).thenReturn(updatedRelacionVA);

        // Act
        modifyRelacionCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).update(relacionVA);
        assertNotEquals(updatedRelacionVA, modifyRelacionCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Relacion_VA returnParam = modifyRelacionCommand.getReturnParam();

        // Assert
        assertEquals(relacionVA, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
