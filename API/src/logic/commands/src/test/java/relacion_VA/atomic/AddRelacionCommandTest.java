package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.AddRelacionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddRelacionCommandTest {
    private AddRelacionCommand addRelacionCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;
    private Relacion_VA relacionVA;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        relacionVA = new Relacion_VA();
        addRelacionCommand = new AddRelacionCommand(relacionVA, dbHandler);
        addRelacionCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA insertedRelacionVA = new Relacion_VA();
        when(relacionVADao.insert(relacionVA)).thenReturn(insertedRelacionVA);

        // Act
        addRelacionCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).insert(relacionVA);
        assertNotEquals(insertedRelacionVA, relacionVA);
    }

    @Test
    public void testGetReturnParam() {
        // Arrange

        // Act
        Relacion_VA returnParam = addRelacionCommand.getReturnParam();

        // Assert
        assertEquals(relacionVA, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addRelacionCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}