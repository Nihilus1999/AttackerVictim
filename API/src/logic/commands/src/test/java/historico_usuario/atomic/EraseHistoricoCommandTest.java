package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.EraseHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseHistoricoCommandTest {
    private EraseHistoricoCommand eraseHistoricoCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        eraseHistoricoCommand = new EraseHistoricoCommand(historicoUsuario, dbHandler);
        eraseHistoricoCommand.setHandler(dbHandler);
        eraseHistoricoCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario deletedHistoricoUsuario = new Historico_Usuario();
        when(historicoUsuarioDao.delete(historicoUsuario)).thenReturn(deletedHistoricoUsuario);

        // Act
        eraseHistoricoCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).delete(historicoUsuario);
        assertNotEquals(deletedHistoricoUsuario, eraseHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();
        eraseHistoricoCommand.setHistoricoUsuario(result);

        // Act
        Historico_Usuario returnParam = eraseHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
