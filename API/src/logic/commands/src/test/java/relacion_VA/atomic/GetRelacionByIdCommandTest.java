package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetRelacionByIdCommandTest {
    private GetRelacionByIdCommand getRelacionByIdCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;
    private Logger logger;
    private long userId;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        userId = 1L;
        getRelacionByIdCommand = new GetRelacionByIdCommand(dbHandler, userId);
        getRelacionByIdCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Relacion_VA resultRelacionVA = new Relacion_VA();
        when(relacionVADao.find(userId, Relacion_VA.class)).thenReturn(resultRelacionVA);

        // Act
        getRelacionByIdCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).find(userId, Relacion_VA.class);
        assertNotEquals(resultRelacionVA, getRelacionByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Relacion_VA resultRelacionVA = new Relacion_VA();

        // Act
        Relacion_VA returnParam = getRelacionByIdCommand.getReturnParam();

        // Assert
        assertNotEquals(resultRelacionVA, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getRelacionByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
