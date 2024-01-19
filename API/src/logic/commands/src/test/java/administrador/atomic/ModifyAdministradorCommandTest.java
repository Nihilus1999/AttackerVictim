package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.ModifyAdministradorCommand;
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

public class ModifyAdministradorCommandTest {
    private ModifyAdministradorCommand modifyAdministradorCommand;
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
        modifyAdministradorCommand = new ModifyAdministradorCommand(administrador, dbHandler);
        modifyAdministradorCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador updatedAdministrador = new Administrador();
        when(administradorDao.update(administrador)).thenReturn(updatedAdministrador);

        // Act
        modifyAdministradorCommand.execute();

        // Assert
        verify(administradorDao,times(0)).update(administrador);
        assertNotEquals(updatedAdministrador, modifyAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Administrador returnParam = modifyAdministradorCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(administrador, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
