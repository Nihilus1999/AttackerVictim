package operaciones;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionByRelacionIDCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetPosicionByRelacionIDCommandTest {

    private Relacion_VA relacionVA;
    private GetPosicionByRelacionIDCommand command;
    private Relacion_VADao dao;

    @BeforeEach
    public void setUp() {
        relacionVA = new Relacion_VA();
        dao = mock(Relacion_VADao.class);
        command = new GetPosicionByRelacionIDCommand(relacionVA);
        command.setDao(dao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Historico_Usuario> result = new ArrayList<>();
        when(dao.getPosicionByRelacionId(relacionVA)).thenReturn(result);

        // Act
        command.execute();

        // Assert
        assertNotEquals(result, command.getReturnParam());
        verify(dao, times(0)).getPosicionByRelacionId(relacionVA);
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
