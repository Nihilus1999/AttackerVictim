package administrador.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAdministradorByListCommandTest {
    private GetAdministradorByListCommand getAdministradorByListCommand;
    private AdministradorDao administradorDao;
    private List<Administrador> administradores;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administradores = new ArrayList<>();
        administradorDao = Mockito.mock(AdministradorDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAdministradorByListCommand = new GetAdministradorByListCommand(dbHandler);
        getAdministradorByListCommand.setDao(administradorDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Administrador> retrievedAdministradores = new ArrayList<>();
        retrievedAdministradores.add(new Administrador());
        retrievedAdministradores.add(new Administrador());
        when(administradorDao.findAll(Administrador.class)).thenReturn(retrievedAdministradores);

        // Act
        getAdministradorByListCommand.execute();

        // Assert
        verify(administradorDao,times(0)).findAll(Administrador.class);
        assertNotEquals(retrievedAdministradores, getAdministradorByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        List<Administrador> returnParam = getAdministradorByListCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(administradores, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAdministradorByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}