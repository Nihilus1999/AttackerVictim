package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByMacCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetUsuarioByMacCommandTest {
    private GetUsuarioByMacCommand getUsuarioByMacCommand;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        usuarioDao = Mockito.mock(UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getUsuarioByMacCommand = new GetUsuarioByMacCommand(usuario);
        getUsuarioByMacCommand.setDao(usuarioDao);
        getUsuarioByMacCommand.setHandler(dbHandler);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario usuarioByMac = new Usuario();
        String mac = "00:11:22:33:44:55";
        usuario.set_direccion_mac(mac);
        when(usuarioDao.getUsuarioByMac(mac)).thenReturn(usuarioByMac);

        // Act
        getUsuarioByMacCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).getUsuarioByMac(mac);
        assertNotEquals(usuarioByMac, getUsuarioByMacCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = getUsuarioByMacCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByMacCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
