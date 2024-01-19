package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.AddHistoricoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddHistoricoCommandTest {
    private AddHistoricoCommand addHistoricoCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;
    private Logger logger;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        logger = Mockito.mock(Logger.class);
        addHistoricoCommand = new AddHistoricoCommand(historicoUsuario, dbHandler);
        addHistoricoCommand.setHandler(dbHandler);
        addHistoricoCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario insertedHistoricoUsuario = new Historico_Usuario();
        when(historicoUsuarioDao.insert(historicoUsuario)).thenReturn(insertedHistoricoUsuario);

        // Act
        addHistoricoCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).insert(historicoUsuario);
        assertNotEquals(insertedHistoricoUsuario, addHistoricoCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();

        // Act
        Historico_Usuario returnParam = addHistoricoCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addHistoricoCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
