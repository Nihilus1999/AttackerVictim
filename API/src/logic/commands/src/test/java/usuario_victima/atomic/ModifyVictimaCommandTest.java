package usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.ModifyVictimaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModifyVictimaCommandTest {
    private ModifyVictimaCommand modifyVictimaCommand;
    private Usuario_VictimaDao usuarioVictimaDao;
    private DBHandler dbHandler;
    private Usuario_Victima usuarioVictima;

    @BeforeEach
    public void setup() {
        usuarioVictimaDao = Mockito.mock(Usuario_VictimaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        usuarioVictima = new Usuario_Victima();
        modifyVictimaCommand = new ModifyVictimaCommand(usuarioVictima, dbHandler);
        modifyVictimaCommand.setDao(usuarioVictimaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Victima updatedVictima = new Usuario_Victima();
        when(usuarioVictimaDao.update(usuarioVictima)).thenReturn(updatedVictima);

        // Act
        modifyVictimaCommand.execute();

        // Assert
        verify(usuarioVictimaDao,times(0)).update(usuarioVictima);
        assertNotEquals(updatedVictima, modifyVictimaCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        modifyVictimaCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }


}
