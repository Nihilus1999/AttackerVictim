package usuario.atomic;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
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

public class AddUsuarioCommandTest {
    private AddUsuarioCommand addUsuarioCommand;
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
        addUsuarioCommand = new AddUsuarioCommand(usuario);
        addUsuarioCommand.setHandler(dbHandler);
        addUsuarioCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario insertedUsuario = new Usuario();
        when(usuarioDao.insert(usuario)).thenReturn(insertedUsuario);

        // Act
        addUsuarioCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).insert(usuario);
        assertNotEquals(insertedUsuario, addUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        Usuario returnParam = addUsuarioCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
