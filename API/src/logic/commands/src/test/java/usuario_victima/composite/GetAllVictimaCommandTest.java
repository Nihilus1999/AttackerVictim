package usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.GetAllVictimaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetAllVictimaCommandTest {
    private GetAllVictimaCommand getAllVictimaCommand;
    private GetVictimaByListCommand getVictimaByListCommand;
    private DBHandler dbHandler;
    private List<Usuario_Victima> usuarioVictimaList;

    @BeforeEach
    public void setup() {
        getVictimaByListCommand = Mockito.mock(GetVictimaByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictimaList = new ArrayList<>();
        getAllVictimaCommand = new GetAllVictimaCommand();
        getAllVictimaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario_Victima> retrievedVictimaList = new ArrayList<>();
        CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
        getAllVictimaCommand.setCommandFactory(commandFactory);

        // Act
        getAllVictimaCommand.execute();

        // Assert
        verify(getVictimaByListCommand,times(0)).execute();
        verify(dbHandler, never()).beginTransaction();
        verify(dbHandler, never()).finishTransaction();
        verify(dbHandler,never()).closeSession();
        assertNotEquals(retrievedVictimaList, getAllVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
