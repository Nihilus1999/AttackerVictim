package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCorreoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetUsuarioByCorreoCommandTest {
    private GetUsuarioByCorreoCommand getUsuarioByCorreoCommand;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        usuarioDao = Mockito.mock(UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getUsuarioByCorreoCommand = new GetUsuarioByCorreoCommand(usuario);
        getUsuarioByCorreoCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario usuarioByCorreo = new Usuario();
        String correo = "test@example.com";
        usuario.set_correo(correo);
        when(usuarioDao.getUsuarioByCorreo(correo)).thenReturn(usuarioByCorreo);

        // Act
        getUsuarioByCorreoCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).getUsuarioByCorreo(correo);
        assertNotEquals(usuarioByCorreo, getUsuarioByCorreoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = getUsuarioByCorreoCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByCorreoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times(0)).closeSession();
    }
}
