package relacion_VA.atomic;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionByRelacionIDCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.Relacion_VADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetPosicionByRelacionIDCommandTest {
    private GetPosicionByRelacionIDCommand getPosicionByRelacionIDCommand;
    private Relacion_VADao relacionVADao;
    private DBHandler dbHandler;
    private Relacion_VA relacionVA;

    @BeforeEach
    public void setup() {
        relacionVADao = Mockito.mock(Relacion_VADao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        relacionVA = new Relacion_VA();
        getPosicionByRelacionIDCommand = new GetPosicionByRelacionIDCommand(relacionVA);
        getPosicionByRelacionIDCommand.setHandler(dbHandler);
        getPosicionByRelacionIDCommand.setDao(relacionVADao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Historico_Usuario> resultList = new ArrayList<>();
        when(relacionVADao.getPosicionByRelacionId(relacionVA)).thenReturn(resultList);

        // Act
        getPosicionByRelacionIDCommand.execute();

        // Assert
        verify(relacionVADao,times(0)).getPosicionByRelacionId(relacionVA);
        assertNotEquals(resultList, getPosicionByRelacionIDCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Historico_Usuario> resultList = new ArrayList<>();

        // Act
        List<Historico_Usuario> returnParam = getPosicionByRelacionIDCommand.getReturnParam();

        // Assert
        assertNotEquals(resultList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getPosicionByRelacionIDCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
