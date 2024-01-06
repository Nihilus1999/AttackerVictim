package usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.EraseVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EraseVictimaCommandTest {
    private EraseVictimaCommand eraseVictimaCommand;
    private Usuario_Victima usuarioVictima;
    private Usuario_VictimaDao usuarioVictimaDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuarioVictima = new Usuario_Victima();
        usuarioVictimaDao = Mockito.mock(Usuario_VictimaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        eraseVictimaCommand = new EraseVictimaCommand(usuarioVictima, dbHandler);
        eraseVictimaCommand.setDao(usuarioVictimaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        when(usuarioVictimaDao.delete(usuarioVictima)).thenReturn(usuarioVictima);

        // Act
        eraseVictimaCommand.execute();

        // Assert
        verify(usuarioVictimaDao,times(0)).delete(usuarioVictima);
        assertEquals(usuarioVictima, eraseVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        eraseVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times(1)).closeSession();
    }

}