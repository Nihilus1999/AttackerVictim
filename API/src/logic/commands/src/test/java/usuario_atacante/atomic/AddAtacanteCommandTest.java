package usuario_atacante.atomic;

import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.commands.usuario_atacante.atomic.AddAtacanteCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.Usuario_AtacanteDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class AddAtacanteCommandTest {
    private AddAtacanteCommand addAtacanteCommand;
    private Usuario_AtacanteDao usuario_AtacanteDao;
    private DBHandler dbHandler;
    private Logger logger;

    @BeforeEach
    public void setup() {
        usuario_AtacanteDao = Mockito.mock(Usuario_AtacanteDao.class);
        dbHandler = Mockito.mock(DBHandler.class);
        logger = Mockito.mock(Logger.class);
        addAtacanteCommand = new AddAtacanteCommand(new Usuario_Atacante(), dbHandler);
        addAtacanteCommand.setDao(usuario_AtacanteDao);
    }

    @Test
    public void testExecute() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        addAtacanteCommand.execute();

        // Assert
        verify(logger, times(0)).debug(anyString());
        assertNotEquals(expectedUsuario_Atacante, addAtacanteCommand.getReturnParam());
    }

    @Test
    public void testGetReturnParam() {
        // Arrange
        Usuario_Atacante expectedUsuario_Atacante = new Usuario_Atacante();

        // Act
        Usuario_Atacante returnParam = addAtacanteCommand.getReturnParam();

        // Assert
        assertNotEquals(expectedUsuario_Atacante, returnParam);
    }

    @Test
    public void testCloseHandlerSession() {
        // Act
        addAtacanteCommand.closeHandlerSession();

        // Assert
        verify(dbHandler).closeSession();
    }
}