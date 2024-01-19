package usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.GetAtacanteByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class GetAtacanteByListCommandTest {
    private GetAtacanteByListCommand getAtacanteByListCommand;
    private Usuario_AtacanteDao usuario_AtacanteDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuario_AtacanteDao = Mockito.mock(Usuario_AtacanteDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        getAtacanteByListCommand = new GetAtacanteByListCommand(dbHandler);
        getAtacanteByListCommand.setDao(usuario_AtacanteDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        List<Usuario_Atacante> expectedUsuario_AtacanteList = new ArrayList<>();
        Usuario_Atacante usuario_Atacante1 = new Usuario_Atacante();
        Usuario_Atacante usuario_Atacante2 = new Usuario_Atacante();
        expectedUsuario_AtacanteList.add(usuario_Atacante1);
        expectedUsuario_AtacanteList.add(usuario_Atacante2);
        when(usuario_AtacanteDao.findAll(Usuario_Atacante.class)).thenReturn(expectedUsuario_AtacanteList);

        // Act
        getAtacanteByListCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        assertNotEquals(expectedUsuario_AtacanteList, getAtacanteByListCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        List<Usuario_Atacante> expectedUsuario_AtacanteList = new ArrayList<>();
        Usuario_Atacante usuario_Atacante1 = new Usuario_Atacante();
        Usuario_Atacante usuario_Atacante2 = new Usuario_Atacante();
        expectedUsuario_AtacanteList.add(usuario_Atacante1);
        expectedUsuario_AtacanteList.add(usuario_Atacante2);

        // Act
        List<Usuario_Atacante> returnParam = getAtacanteByListCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_AtacanteList, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        getAtacanteByListCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}
