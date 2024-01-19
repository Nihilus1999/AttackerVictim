package usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetVictimaByIdCommandTest {
    private GetVictimaByIdCommand getVictimaByIdCommand;
    private long userId;
    private Usuario_Victima usuarioVictima;
    private Usuario_VictimaDao usuarioVictimaDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        userId = 1L;
        usuarioVictima = new Usuario_Victima();
        usuarioVictimaDao = Mockito.mock(Usuario_VictimaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getVictimaByIdCommand = new GetVictimaByIdCommand(dbHandler, userId);
        getVictimaByIdCommand.setDao(usuarioVictimaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(usuarioVictimaDao.find(userId, Usuario_Victima.class)).thenReturn(usuarioVictima);

        // Act
        getVictimaByIdCommand.execute();

        // Assert
        verify(usuarioVictimaDao,times(0)).find(userId, Usuario_Victima.class);
        assertNotEquals(usuarioVictima, getVictimaByIdCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getVictimaByIdCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times( 1)).closeSession();
    }

}
