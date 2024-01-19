package usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.GetVictimaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetVictimaCommandTest {
    private GetVictimaCommand getVictimaCommand;
    private GetVictimaByIdCommand getVictimaByIdCommand;
    private DBHandler dbHandler;
    private Usuario_Victima usuarioVictima;
    private long id;

    @BeforeEach
    public void setup() {
        getVictimaByIdCommand = Mockito.mock(GetVictimaByIdCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictima = new Usuario_Victima();
        id = 123456789L;
        getVictimaCommand = new GetVictimaCommand(usuarioVictima);
        getVictimaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Victima retrievedVictima = new Usuario_Victima();
        CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
        getVictimaCommand.setCommandFactory(commandFactory);

        // Act
        getVictimaCommand.execute();

        // Assert
        verify(getVictimaByIdCommand,times(0)).execute();
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(retrievedVictima, getVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
