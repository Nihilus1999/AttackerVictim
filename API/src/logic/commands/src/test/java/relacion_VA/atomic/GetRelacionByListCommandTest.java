package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetRelacionByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetRelacionByListCommandTest {
    private GetRelacionByListCommand getRelacionByListCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getRelacionByListCommand = new GetRelacionByListCommand(dbHandler);
        getRelacionByListCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Relacion_VA> resultList = new ArrayList<>();
        when(relacionVADao.findAll(Relacion_VA.class)).thenReturn(resultList);

        // Act
        getRelacionByListCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).findAll(Relacion_VA.class);
        assertNotEquals(resultList, getRelacionByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Relacion_VA> resultList = new ArrayList<>();

        // Act
        List<Relacion_VA> returnParam = getRelacionByListCommand.getReturnParam();

        // Assert
        assertNotEquals(resultList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getRelacionByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
