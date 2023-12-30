package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.AddAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class AddAdministradorCommandTest {

    @Mock
    private AdministradorDao administradorDao;

    @Mock
    private DBHandler dbHandler;

    @Mock
    private Logger logger;

    private Administrador administrador;

    private AddAdministradorCommand addAdministradorCommand;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        administrador = new Administrador();
        addAdministradorCommand = new AddAdministradorCommand(administrador, dbHandler);
        addAdministradorCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador expectedAdministrador = new Administrador();
        when(administradorDao.insert(administrador)).thenReturn(expectedAdministrador);

        // Act
        addAdministradorCommand.execute();

        // Assert
        verify(administradorDao, times(0)).insert(administrador);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler, times(1)).closeSession();
    }
}