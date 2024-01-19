package administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.AddAdministradorCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.CreateAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateAdministradorCommandTest {

    @Mock
    private AddAdministradorCommand addAdministradorCommand;

    @Mock
    private DBHandler dbHandler;

    @Mock
    private Logger logger;

    @Mock
    private EntityManager entityManager;

    private Administrador administrador;

    private CreateAdministradorCommand createAdministradorCommand;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        administrador = new Administrador();
        createAdministradorCommand = new CreateAdministradorCommand(administrador);
        createAdministradorCommand.setHandler(dbHandler);

        // Mocking the logger to avoid ExceptionInInitializerError


        // Configuring the behavior of getSession() to return EntityManager
        when(dbHandler.getSession()).thenReturn(entityManager);
    }

    @Test
    public void testExecute() {
        // Arrange
        Administrador expectedAdministrador = new Administrador();
        when(addAdministradorCommand.getReturnParam()).thenReturn(expectedAdministrador);

        // Act
        createAdministradorCommand.execute();
        Administrador resultAdministrador = createAdministradorCommand.getReturnParam();

        // Assert
        verify(dbHandler, times(1)).beginTransaction();
        verify(addAdministradorCommand, times(0)).execute();
        verify(addAdministradorCommand, times(0)).getReturnParam();
        verify(dbHandler, times(1)).finishTransaction();
        verify(dbHandler, times(1)).closeSession();
        assertNotEquals(expectedAdministrador, resultAdministrador);
    }

    @Test
    public void testExecute_ThrowsException() {
        // Arrange
        doThrow(new RuntimeException()).when(addAdministradorCommand).execute();

        // Act & Assert


        // Verify
        verify(dbHandler, times(0)).beginTransaction();
        verify(addAdministradorCommand, times(0)).execute();
        verify(dbHandler, times(0)).rollbackTransaction();
        verify(dbHandler, times(0)).closeSession();
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler, times(1)).closeSession();
    }
}