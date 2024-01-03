package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetUsuarioByListCommandTest {
    private GetUsuarioByListCommand getUsuarioByListCommand;
    private DBHandler dbHandler;
    private UsuarioDao usuarioDao;

    @BeforeEach
    public void setup() {
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioDao = Mockito.mock(UsuarioDao.class);
        getUsuarioByListCommand = new GetUsuarioByListCommand(dbHandler);
        getUsuarioByListCommand.setHandler(dbHandler);
        getUsuarioByListCommand.setUsuarioDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario> result = new ArrayList<>();
        when(usuarioDao.findAll(Usuario.class)).thenReturn(result);

        // Act
        getUsuarioByListCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).findAll(Usuario.class);
        assertNotEquals(result, getUsuarioByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Usuario> result = new ArrayList<>();

        // Act
        List<Usuario> returnParam = getUsuarioByListCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
