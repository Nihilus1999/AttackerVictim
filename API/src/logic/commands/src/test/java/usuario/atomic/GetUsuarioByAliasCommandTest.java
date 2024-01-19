package usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByAliasCommand;
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

public class GetUsuarioByAliasCommandTest {
    private GetUsuarioByAliasCommand getUsuarioByAliasCommand;
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
        getUsuarioByAliasCommand = new GetUsuarioByAliasCommand(usuario);
        getUsuarioByAliasCommand.setDao(usuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario usuarioByAlias = new Usuario();
        String alias = "_alias";
        usuario.set_alias(alias);
        when(usuarioDao.getUsuarioByAlias(alias)).thenReturn(usuarioByAlias);

        // Act
        getUsuarioByAliasCommand.execute();

        // Assert
        verify(usuarioDao,times(0)).getUsuarioByAlias(alias);
        assertNotEquals(usuarioByAlias, getUsuarioByAliasCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Usuario returnParam = getUsuarioByAliasCommand.getReturnParam();

        // Assert
        assertNotNull(returnParam);
        assertEquals(usuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getUsuarioByAliasCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times(0)).closeSession();
    }
}