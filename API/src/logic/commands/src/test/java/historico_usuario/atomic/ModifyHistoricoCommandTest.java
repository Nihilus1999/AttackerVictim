package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.ModifyHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyHistoricoCommandTest {
    private ModifyHistoricoCommand modifyHistoricoCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        modifyHistoricoCommand = new ModifyHistoricoCommand(historicoUsuario, dbHandler);
        modifyHistoricoCommand.setHandler(dbHandler);
        modifyHistoricoCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario updatedHistoricoUsuario = new Historico_Usuario();
        when(historicoUsuarioDao.update(historicoUsuario)).thenReturn(updatedHistoricoUsuario);

        // Act
        modifyHistoricoCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).update(historicoUsuario);
        assertNotEquals(updatedHistoricoUsuario, modifyHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Act
        Historico_Usuario returnParam = modifyHistoricoCommand.getReturnParam();

        // Assert
        assertEquals(historicoUsuario, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
