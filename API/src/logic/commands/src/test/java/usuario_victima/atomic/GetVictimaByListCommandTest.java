package usuario_victima.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.commands.usuario_victima.atomic.GetVictimaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_VictimaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetVictimaByListCommandTest {
    private GetVictimaByListCommand getVictimaByListCommand;
    private Usuario_VictimaDao usuarioVictimaDao;
    private DBHandler dbHandler;

    @BeforeEach
    public void setup() {
        usuarioVictimaDao = Mockito.mock(Usuario_VictimaDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        getVictimaByListCommand = new GetVictimaByListCommand(dbHandler);
        getVictimaByListCommand.setDao(usuarioVictimaDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario_Victima> resultList = new ArrayList<>();
        Usuario_Victima usuarioVictima1 = new Usuario_Victima();
        Usuario_Victima usuarioVictima2 = new Usuario_Victima();
        resultList.add(usuarioVictima1);
        resultList.add(usuarioVictima2);
        when(usuarioVictimaDao.findAll(Usuario_Victima.class)).thenReturn(resultList);

        // Act
        getVictimaByListCommand.execute();

        // Assert
        verify(usuarioVictimaDao,times(0)).findAll(Usuario_Victima.class);
        assertNotEquals(resultList, getVictimaByListCommand.getReturnParam());
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getVictimaByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler,times(1)).closeSession();
    }


}
