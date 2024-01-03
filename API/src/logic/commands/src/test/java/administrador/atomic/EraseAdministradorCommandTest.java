package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.EraseAdministradorCommand;
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

public class EraseAdministradorCommandTest {
    private EraseAdministradorCommand eraseAdministradorCommand;
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
        eraseAdministradorCommand = new EraseAdministradorCommand(administrador, dbHandler);
        eraseAdministradorCommand.setHandler(dbHandler);
        eraseAdministradorCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador deletedAdministrador = new Administrador();
        when(administradorDao.delete(administrador)).thenReturn(deletedAdministrador);

        // Act
        eraseAdministradorCommand.execute();

        // Assert
        verify(administradorDao,times(0)).delete(administrador);
        assertNotEquals(deletedAdministrador, eraseAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Administrador returnParam = eraseAdministradorCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(administrador, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}