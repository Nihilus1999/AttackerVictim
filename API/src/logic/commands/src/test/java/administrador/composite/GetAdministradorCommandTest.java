package administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByIdCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.GetAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GetAdministradorCommandTest {
    private GetAdministradorCommand getAdministradorCommand;
    private Administrador administrador;
    private GetAdministradorByIdCommand getAdministradorByIdCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administrador = new Administrador();
        getAdministradorByIdCommand = Mockito.mock(GetAdministradorByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAdministradorCommand = new GetAdministradorCommand(administrador);
        getAdministradorCommand.setHandler(dbHandler);
        getAdministradorCommand.setGetAdministradorByIdCommand(getAdministradorByIdCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Administrador retrievedAdministrador = new Administrador();
        when(getAdministradorByIdCommand.getReturnParam()).thenReturn(retrievedAdministrador);

        // Act
        getAdministradorCommand.execute();

        // Assert
        verify(getAdministradorByIdCommand,times(0)).execute();
        assertNotEquals(retrievedAdministrador, getAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Administrador result = new Administrador();

        // Act
        Administrador returnParam = getAdministradorCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
