package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByCorreoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAdministradorByCorreoCommandTest {
    private GetAdministradorByCorreoCommand getAdministradorByCorreoCommand;
    private Administrador administrador;
    private DBHandler dbHandler;
    private AdministradorDao administradorDao;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administrador = new Administrador();
        dbHandler = Mockito.mock(DBHandler.class);
        administradorDao = Mockito.mock(AdministradorDao.class);
        logger = Mockito.mock(Logger.class);
        getAdministradorByCorreoCommand = new GetAdministradorByCorreoCommand(administrador);
        getAdministradorByCorreoCommand.setHandler(dbHandler);
        getAdministradorByCorreoCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador retrievedAdministrador = new Administrador();
        String correo = "test_correo";
        administrador.set_correo(correo);
        when(administradorDao.getAdministradorByCorreo(correo)).thenReturn(retrievedAdministrador);

        // Act
        getAdministradorByCorreoCommand.execute();

        // Assert
        verify(administradorDao,times(0)).getAdministradorByCorreo(correo);
        assertNotEquals(retrievedAdministrador, getAdministradorByCorreoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Administrador returnParam = getAdministradorByCorreoCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(administrador, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAdministradorByCorreoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
