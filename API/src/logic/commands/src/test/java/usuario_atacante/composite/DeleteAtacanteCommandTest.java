package usuario_atacante.composite;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.EraseAtacanteCommand;
import com.ucab.cmcapp.logic.commands.usuario_atacante.composite.DeleteAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteAtacanteCommandTest {
    private DeleteAtacanteCommand deleteAtacanteCommand;
    private EraseAtacanteCommand eraseAtacanteCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        eraseAtacanteCommand = Mockito.mock(EraseAtacanteCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        deleteAtacanteCommand = new DeleteAtacanteCommand(new Usuario_Atacante());
        deleteAtacanteCommand.setHandler(dbHandler);
        deleteAtacanteCommand.setEraseAtacanteCommand(eraseAtacanteCommand);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();
        when(eraseAtacanteCommand.getReturnParam()).thenReturn(expectedUsuario_Atacante);

        // Act
        deleteAtacanteCommand.execute();

        // Assert
        verify(eraseAtacanteCommand,times(0)).execute();
        verify(eraseAtacanteCommand,times(0)).getReturnParam();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(expectedUsuario_Atacante, deleteAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        Usuario_Atacante returnParam = deleteAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_Atacante, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
