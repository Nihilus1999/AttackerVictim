package administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.administrador.atomic.EraseAdministradorCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.DeleteAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DeleteAdministradorCommandTest {
    private DeleteAdministradorCommand deleteAdministradorCommand;
    private Administrador administrador;
    private EraseAdministradorCommand eraseAdministradorCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administrador = new Administrador();
        eraseAdministradorCommand = Mockito.mock(EraseAdministradorCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        deleteAdministradorCommand = new DeleteAdministradorCommand(administrador);
        deleteAdministradorCommand.setHandler(dbHandler);
        deleteAdministradorCommand.setEraseAdministradorCommand(eraseAdministradorCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Administrador erasedAdministrador = new Administrador();
        when(eraseAdministradorCommand.getReturnParam()).thenReturn(erasedAdministrador);

        // Act
        deleteAdministradorCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(eraseAdministradorCommand,times(0)).execute();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(erasedAdministrador, deleteAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Administrador result = new Administrador();

        // Act
        Administrador returnParam = deleteAdministradorCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
