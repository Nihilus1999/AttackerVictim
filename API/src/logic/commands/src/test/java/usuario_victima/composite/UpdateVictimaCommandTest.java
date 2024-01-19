package usuario_victima.composite;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.ModifyVictimaCommand;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.UpdateVictimaCommand;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateVictimaCommandTest {
    private UpdateVictimaCommand updateVictimaCommand;
    private ModifyVictimaCommand modifyVictimaCommand;
    private DBHandler dbHandler;
    private Usuario_Victima usuarioVictima;
    private Usuario_Victima result;

    @BeforeEach
    public void setup() {
        modifyVictimaCommand = Mockito.mock(ModifyVictimaCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictima = new Usuario_Victima();
        result = new Usuario_Victima();
        updateVictimaCommand = new UpdateVictimaCommand(usuarioVictima);
        updateVictimaCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
        updateVictimaCommand.setCommandFactory(commandFactory);

        // Act
        updateVictimaCommand.execute();

        // Assert
        verify(dbHandler,times(1)).beginTransaction();
        verify(modifyVictimaCommand,times(0)).execute();
        assertNotEquals(modifyVictimaCommand.getReturnParam(), updateVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        updateVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }


}
