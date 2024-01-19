package usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.EraseVictimaCommand;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.DeleteVictimaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeleteVictimaCommandTest {
    private DeleteVictimaCommand deleteVictimaCommand;
    private EraseVictimaCommand eraseVictimaCommand;
    private DBHandler dbHandler;
    private Usuario_Victima usuarioVictima;

    @BeforeEach
    public void setup() {
        eraseVictimaCommand = Mockito.mock(EraseVictimaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictima = new Usuario_Victima();
        deleteVictimaCommand = new DeleteVictimaCommand(usuarioVictima);
        deleteVictimaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Victima deletedVictima = new Usuario_Victima();
        CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
        deleteVictimaCommand.setCommandFactory(commandFactory);

        // Act
        deleteVictimaCommand.execute();

        // Assert
        verify(eraseVictimaCommand,times(0)).execute();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(deletedVictima, deleteVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        deleteVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
