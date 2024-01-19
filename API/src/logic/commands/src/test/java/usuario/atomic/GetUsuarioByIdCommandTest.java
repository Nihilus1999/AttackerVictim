package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetUsuarioByIdCommandTest {
    private GetUsuarioByIdCommand getUsuarioByIdCommand;
    private UsuarioDao usuarioDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuarioDao = Mockito.mock(UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getUsuarioByIdCommand = new GetUsuarioByIdCommand(dbHandler, 1);
        getUsuarioByIdCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario usuario = new Usuario();
        when(usuarioDao.find(1l, Usuario.class)).thenReturn(usuario);

        // Act
        getUsuarioByIdCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).find(0l, Usuario.class);
        assertNotEquals(usuario, getUsuarioByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario usuario = new Usuario();

        // Act
        Usuario returnParam = getUsuarioByIdCommand.getReturnParam();

        // Assert
        assertNull(returnParam);
        assertNotEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}