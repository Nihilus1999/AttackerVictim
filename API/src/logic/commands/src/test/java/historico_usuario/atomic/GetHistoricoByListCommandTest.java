package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historico_UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetHistoricoByListCommandTest {
    private GetHistoricoByListCommand getHistoricoByListCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getHistoricoByListCommand = new GetHistoricoByListCommand(dbHandler);
        getHistoricoByListCommand.setHandler(dbHandler);
        getHistoricoByListCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Historico_Usuario> foundHistoricoUsuarios = new ArrayList<>();
        when(historicoUsuarioDao.findAll(Historico_Usuario.class)).thenReturn(foundHistoricoUsuarios);

        // Act
        getHistoricoByListCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).findAll(Historico_Usuario.class);
        assertNotEquals(foundHistoricoUsuarios, getHistoricoByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Historico_Usuario> result = new ArrayList<>();

        // Act
        List<Historico_Usuario> returnParam = getHistoricoByListCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getHistoricoByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
