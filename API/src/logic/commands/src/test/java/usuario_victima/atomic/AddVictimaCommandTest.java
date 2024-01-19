package usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.AddVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddVictimaCommandTest {

    private Usuario_Victima usuarioVictima;
    private AddVictimaCommand command;
    private Usuario_VictimaDao dao;

    @BeforeEach
    public void setUp() {
        usuarioVictima = new Usuario_Victima();
        dao = mock(Usuario_VictimaDao.class);
        command = new AddVictimaCommand(usuarioVictima);
        command.setDao(dao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Victima result = new Usuario_Victima();
        when(dao.insert(usuarioVictima)).thenReturn(result);

        // Act
        command.execute();

        // Assert
        assertNotEquals(result, command.getReturnParam());
        verify(dao, times(0)).insert(usuarioVictima);
    }

    @Test
    public void testCloseHandlerSession() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);
        command.setHandler(handler);

        // Act
        command.closeHandlerSession();

        // Assert
        verify(handler, times(1)).closeSession();
    }


}