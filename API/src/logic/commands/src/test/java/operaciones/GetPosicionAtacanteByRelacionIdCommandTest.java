package operaciones;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionAtacanteByRelacionIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetPosicionAtacanteByRelacionIdCommandTest {

    private Relacion_VA relacionVA;
    private GetPosicionAtacanteByRelacionIdCommand command;
    private Relacion_VADao dao;

    @BeforeEach
    public void setUp() {
        relacionVA = new Relacion_VA();
        dao = mock(Relacion_VADao.class);
        command = new GetPosicionAtacanteByRelacionIdCommand(relacionVA);
        command.setDao(dao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Historico_Usuario result = new Historico_Usuario();
        when(dao.getPosicionAtacanteByRelacionId(relacionVA)).thenReturn(result);

        // Act
        command.execute();

        // Assert
        assertNotEquals(result, command.getReturnParam());
        verify(dao, times(0)).getPosicionAtacanteByRelacionId(relacionVA);
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
