package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.ModifyUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ModifyUsuarioCommandTest {
    private ModifyUsuarioCommand modifyUsuarioCommand;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        usuarioDao = Mockito.mock(UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        modifyUsuarioCommand = new ModifyUsuarioCommand(usuario, dbHandler);
        modifyUsuarioCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario updatedUsuario = new Usuario();
        when(usuarioDao.update(usuario)).thenReturn(updatedUsuario);

        // Act
        modifyUsuarioCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).update(usuario);
        assertNotEquals(updatedUsuario, modifyUsuarioCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = modifyUsuarioCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyUsuarioCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
