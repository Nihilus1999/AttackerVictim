package usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.AddAtacanteCommand;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.CreateAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class CreateAtacanteCommandTest {
    private CreateAtacanteCommand createAtacanteCommand;
    private AddAtacanteCommand addAtacanteCommand;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        addAtacanteCommand = Mockito.mock(AddAtacanteCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        createAtacanteCommand = new CreateAtacanteCommand(new Usuario_Atacante());
        createAtacanteCommand.setHandler(dbHandler);
        createAtacanteCommand.setAddAtacanteCommand(addAtacanteCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();
        when(addAtacanteCommand.getReturnParam()).thenReturn(expectedUsuario_Atacante);

        // Act
        createAtacanteCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        verify(addAtacanteCommand,times(0)).execute();
        verify(addAtacanteCommand,times(0)).getReturnParam();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedUsuario_Atacante, createAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        Usuario_Atacante returnParam = createAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_Atacante, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}