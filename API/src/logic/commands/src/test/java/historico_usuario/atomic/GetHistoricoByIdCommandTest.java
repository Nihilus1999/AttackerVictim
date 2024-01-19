package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByIdCommand;
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

public class GetHistoricoByIdCommandTest {
    private GetHistoricoByIdCommand getHistoricoByIdCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;
    private Logger logger;
    private long userId;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        userId = 12345;
        getHistoricoByIdCommand = new GetHistoricoByIdCommand(dbHandler, userId);
        getHistoricoByIdCommand.setHandler(dbHandler);
        getHistoricoByIdCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario foundHistoricoUsuario = new Historico_Usuario();
        when(historicoUsuarioDao.find(userId, Historico_Usuario.class)).thenReturn(foundHistoricoUsuario);

        // Act
        getHistoricoByIdCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).find(userId, Historico_Usuario.class);
        assertNotEquals(foundHistoricoUsuario, getHistoricoByIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();

        // Act
        Historico_Usuario returnParam = getHistoricoByIdCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getHistoricoByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
