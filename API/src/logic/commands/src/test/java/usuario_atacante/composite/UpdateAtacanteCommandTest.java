package usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.ModifyAtacanteCommand;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.UpdateAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateAtacanteCommandTest {
    private UpdateAtacanteCommand updateAtacanteCommand;
    private ModifyAtacanteCommand modifyAtacanteCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        modifyAtacanteCommand = Mockito.mock(ModifyAtacanteCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        updateAtacanteCommand = new UpdateAtacanteCommand(new Usuario_Atacante());
        updateAtacanteCommand.setHandler(dbHandler);
        updateAtacanteCommand.setModifyAtacanteCommand(modifyAtacanteCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();
        when(modifyAtacanteCommand.getReturnParam()).thenReturn(expectedUsuario_Atacante);

        // Act
        updateAtacanteCommand.execute();

        // Assert
        verify(modifyAtacanteCommand,times(0)).execute();
        verify(modifyAtacanteCommand,times(0)).getReturnParam();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedUsuario_Atacante, updateAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        Usuario_Atacante returnParam = updateAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_Atacante, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
