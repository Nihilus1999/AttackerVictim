package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.EraseUsuarioCommand;
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

public class EraseUsuarioCommandTest {
    private EraseUsuarioCommand eraseUsuarioCommand;
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
        eraseUsuarioCommand = new EraseUsuarioCommand(usuario, dbHandler);
        eraseUsuarioCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario deletedUsuario = new Usuario();
        when(usuarioDao.delete(usuario)).thenReturn(deletedUsuario);

        // Act
        eraseUsuarioCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).delete(usuario);
        assertNotEquals(deletedUsuario, eraseUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = eraseUsuarioCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
