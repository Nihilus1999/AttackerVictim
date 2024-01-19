package administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.GetAdministradorByListCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.GetAllAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
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

public class GetAllAdministradorCommandTest {
    private GetAllAdministradorCommand getAllAdministradorCommand;
    private List<Administrador> administradorList;
    private GetAdministradorByListCommand getAdministradorByListCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administradorList = new ArrayList<>();
        getAdministradorByListCommand = Mockito.mock(GetAdministradorByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAllAdministradorCommand = new GetAllAdministradorCommand();
        getAllAdministradorCommand.setHandler(dbHandler);
        getAllAdministradorCommand.setGetAdministradorByListCommand(getAdministradorByListCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        List<Administrador> retrievedAdministradorList = new ArrayList<>();
        when(getAdministradorByListCommand.getReturnParam()).thenReturn(retrievedAdministradorList);

        // Act
        getAllAdministradorCommand.execute();

        // Assert
        verify(getAdministradorByListCommand,times(0)).execute();
        assertNotEquals(retrievedAdministradorList, getAllAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Administrador> result = new ArrayList<>();

        // Act
        List<Administrador> returnParam = getAllAdministradorCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
