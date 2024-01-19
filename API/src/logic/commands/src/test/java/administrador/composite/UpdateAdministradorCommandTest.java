package administrador.composite;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.commands.administrador.atomic.ModifyAdministradorCommand;
import com.ucab.cmcapp.logic.commands.administrador.composite.UpdateAdministradorCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateAdministradorCommandTest {
    private UpdateAdministradorCommand updateAdministradorCommand;
    private Administrador administrador;
    private ModifyAdministradorCommand modifyAdministradorCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        administrador = new Administrador();
        modifyAdministradorCommand = Mockito.mock(ModifyAdministradorCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        updateAdministradorCommand = new UpdateAdministradorCommand(administrador);
        updateAdministradorCommand.setHandler(dbHandler);
        updateAdministradorCommand.setModifyAdministradorCommand(modifyAdministradorCommand);
    }

    @Test
    public void testExecute() throws Exception {
        // Arrange
        Administrador modifiedAdministrador = new Administrador();
        when(modifyAdministradorCommand.getReturnParam()).thenReturn(modifiedAdministrador);

        // Act
        updateAdministradorCommand.execute();

        // Assert
        verify(modifyAdministradorCommand,times(0)).execute();
        assertNotEquals(modifiedAdministrador, updateAdministradorCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Administrador result = new Administrador();

        // Act
        Administrador returnParam = updateAdministradorCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateAdministradorCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
