package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByAliasCommand;
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

public class GetAdministradorByAliasCommandTest {
    private GetAdministradorByAliasCommand getAdministradorByAliasCommand;
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
        getAdministradorByAliasCommand = new GetAdministradorByAliasCommand(administrador);
        getAdministradorByAliasCommand.setHandler(dbHandler);
        getAdministradorByAliasCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador retrievedAdministrador = new Administrador();
        String alias = "test_alias";
        administrador.set_alias(alias);
        when(administradorDao.getAdministradorByAlias(alias)).thenReturn(retrievedAdministrador);

        // Act
        getAdministradorByAliasCommand.execute();

        // Assert
        verify(administradorDao,times(0)).getAdministradorByAlias(alias);
        assertNotEquals(retrievedAdministrador, getAdministradorByAliasCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Administrador returnParam = getAdministradorByAliasCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(administrador, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAdministradorByAliasCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
