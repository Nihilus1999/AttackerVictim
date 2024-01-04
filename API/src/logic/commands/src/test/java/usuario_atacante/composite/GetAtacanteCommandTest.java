package usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.GetAtacanteByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.GetAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAtacanteCommandTest {
    private GetAtacanteCommand getAtacanteCommand;
    private GetAtacanteByIdCommand getAtacanteByIdCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        getAtacanteByIdCommand = Mockito.mock(GetAtacanteByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAtacanteCommand = new GetAtacanteCommand(new Usuario_Atacante());
        getAtacanteCommand.setHandler(dbHandler);
        getAtacanteCommand.setGetAtacanteByIdCommand(getAtacanteByIdCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();
        when(getAtacanteByIdCommand.getReturnParam()).thenReturn(expectedUsuario_Atacante);

        // Act
        getAtacanteCommand.execute();

        // Assert
        verify(getAtacanteByIdCommand,times(0)).execute();
        verify(getAtacanteByIdCommand,times(0)).getReturnParam();
        verify(dbHandler,times(0)).rollbackTransaction();
        verify(dbHandler,times(0)).closeSession();
        assertNotEquals(expectedUsuario_Atacante, getAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        Usuario_Atacante returnParam = getAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_Atacante, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
