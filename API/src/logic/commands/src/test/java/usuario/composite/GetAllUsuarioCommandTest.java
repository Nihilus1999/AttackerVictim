package usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByListCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetAllUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAllUsuarioCommandTest {
    private GetAllUsuarioCommand getAllUsuarioCommand;
    private List<Usuario> usuarios;
    private GetUsuarioByListCommand getUsuarioByListCommand;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuarios = new ArrayList<>();
        getUsuarioByListCommand = Mockito.mock(GetUsuarioByListCommand.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getAllUsuarioCommand = new GetAllUsuarioCommand();
        getAllUsuarioCommand.setGetUsuarioByListCommand(getUsuarioByListCommand);
        getAllUsuarioCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(new Usuario());
        when(getUsuarioByListCommand.getReturnParam()).thenReturn(usuarioList);

        // Act
        getAllUsuarioCommand.execute();

        // Assert
        verify(getUsuarioByListCommand,times(0)).execute();
        assertNotEquals(usuarioList, getAllUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Usuario> result = new ArrayList<>();

        // Act
        List<Usuario> returnParam = getAllUsuarioCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAllUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
