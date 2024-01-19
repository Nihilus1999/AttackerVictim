package usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.CreateVictimaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateVictimaCommandTest {
    private CreateVictimaCommand createVictimaCommand;
    private AddVictimaCommand addVictimaCommand;
    private DBHandler dbHandler;
    private Usuario_Victima usuarioVictima;

    @BeforeEach
    public void setup() {
        addVictimaCommand = Mockito.mock(AddVictimaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictima = new Usuario_Victima();
        createVictimaCommand = new CreateVictimaCommand(usuarioVictima);
        createVictimaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Victima createdVictima = new Usuario_Victima();
        when(addVictimaCommand.getReturnParam()).thenReturn(createdVictima);
        CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
        createVictimaCommand.setCommandFactory(commandFactory);

        // Act
        createVictimaCommand.execute();

        // Assert
        verify(addVictimaCommand,times(0)).execute();
        verify(addVictimaCommand,times(0)).getReturnParam();
        verify(dbHandler,times(1)).beginTransaction();
        verify(dbHandler,times(1)).finishTransaction();
        verify(dbHandler,times(1)).closeSession();
        assertNotEquals(createdVictima, createVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        createVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }

}
