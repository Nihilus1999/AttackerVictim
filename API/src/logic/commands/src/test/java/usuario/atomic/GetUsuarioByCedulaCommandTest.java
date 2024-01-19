package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByCedulaCommand;
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

public class GetUsuarioByCedulaCommandTest {
    private GetUsuarioByCedulaCommand getUsuarioByCedulaCommand;
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
        getUsuarioByCedulaCommand = new GetUsuarioByCedulaCommand(usuario);
        getUsuarioByCedulaCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario usuarioByCedula = new Usuario();
        String cedula = "12345678";
        usuario.set_cedula(cedula);
        when(usuarioDao.getUsuarioByCedula(cedula)).thenReturn(usuarioByCedula);

        // Act
        getUsuarioByCedulaCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).getUsuarioByCedula(cedula);
        assertNotEquals(usuarioByCedula, getUsuarioByCedulaCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = getUsuarioByCedulaCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByCedulaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times(0)).closeSession();
    }
}
