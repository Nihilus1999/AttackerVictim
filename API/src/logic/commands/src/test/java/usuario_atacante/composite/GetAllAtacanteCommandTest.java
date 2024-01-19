package usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.GetAtacanteByListCommand;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.GetAllAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllAtacanteCommandTest {
    private GetAllAtacanteCommand getAllAtacanteCommand;
    private GetAtacanteByListCommand getAtacanteByListCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getAtacanteByListCommand = Mockito.mock(GetAtacanteByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAllAtacanteCommand = new GetAllAtacanteCommand();
        getAllAtacanteCommand.setHandler(dbHandler);
        getAllAtacanteCommand.setGetAtacanteByListCommand(getAtacanteByListCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario_Atacante> expectedUsuario_AtacanteList = new ArrayList<>();
        when(getAtacanteByListCommand.getReturnParam()).thenReturn(expectedUsuario_AtacanteList);

        // Act
        getAllAtacanteCommand.execute();

        // Assert
        verify(getAtacanteByListCommand,times(0)).execute();
        verify(getAtacanteByListCommand,times(0)).getReturnParam();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedUsuario_AtacanteList, getAllAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Usuario_Atacante> expectedUsuario_AtacanteList = new ArrayList<>();

        // Act
        List<Usuario_Atacante> returnParam = getAllAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_AtacanteList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
