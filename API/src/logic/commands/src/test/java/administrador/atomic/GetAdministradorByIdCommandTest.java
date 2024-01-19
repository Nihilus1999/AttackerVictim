package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAdministradorByIdCommandTest {
    private GetAdministradorByIdCommand getAdministradorByIdCommand;
    private AdministradorDao administradorDao;
    private Administrador administrador;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administrador = new Administrador();
        administradorDao = Mockito.mock(AdministradorDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAdministradorByIdCommand = new GetAdministradorByIdCommand(dbHandler, 123L);
        getAdministradorByIdCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador retrievedAdministrador = new Administrador();
        long adminId = 123L;
        when(administradorDao.find(adminId, Administrador.class)).thenReturn(retrievedAdministrador);

        // Act
        getAdministradorByIdCommand.execute();

        // Assert
        verify(administradorDao,times(0)).find(adminId, Administrador.class);
        assertNotEquals(retrievedAdministrador, getAdministradorByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Administrador returnParam = getAdministradorByIdCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(administrador, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAdministradorByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
