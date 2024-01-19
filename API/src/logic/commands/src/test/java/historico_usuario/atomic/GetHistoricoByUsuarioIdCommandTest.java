package historico_usuario.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.logic.commands.historico_usuario.atomic.GetHistoricoByUsuarioIdCommand;
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

public class GetHistoricoByUsuarioIdCommandTest {
    private GetHistoricoByUsuarioIdCommand getHistoricoByUsuarioIdCommand;
    private Historico_UsuarioDao historicoUsuarioDao;
    private DBHandler dbHandler;
    private Historico_Usuario historicoUsuario;

    @BeforeEach
    public void setup() {
        historicoUsuarioDao = Mockito.mock(Historico_UsuarioDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        historicoUsuario = new Historico_Usuario();
        getHistoricoByUsuarioIdCommand = new GetHistoricoByUsuarioIdCommand(historicoUsuario);
        getHistoricoByUsuarioIdCommand.setHandler(dbHandler);
        getHistoricoByUsuarioIdCommand.setHistoricoUsuarioDao(historicoUsuarioDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Historico_Usuario> foundHistoricoUsuarios = new ArrayList<>();
        when(historicoUsuarioDao.getAllHistoricoByUserId(historicoUsuario.get_usuario())).thenReturn(foundHistoricoUsuarios);

        // Act
        getHistoricoByUsuarioIdCommand.execute();

        // Assert
        verify(historicoUsuarioDao,times(0)).getAllHistoricoByUserId(historicoUsuario.get_usuario());
        assertNotEquals(foundHistoricoUsuarios, getHistoricoByUsuarioIdCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Historico_Usuario> result = new ArrayList<>();

        // Act
        List<Historico_Usuario> returnParam = getHistoricoByUsuarioIdCommand.getReturnParam();

        // Assert
        assertNotEquals(result, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getHistoricoByUsuarioIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
