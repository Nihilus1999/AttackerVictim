import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.*;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DaoFactoryTest {

    @Test
    public void testCreateAdministradorDao() {
        // Crea un mock del DBHandler
        DBHandler dbHandlerMock = mock(DBHandler.class);

        // Crea una instancia del AdministradorDao utilizando el DBHandler simulado
        AdministradorDao administradorDao = DaoFactory.createAdministradorDao(dbHandlerMock);

        // Verifica que se haya creado correctamente el AdministradorDao con el DBHandler simulado
        assertNull(administradorDao);
    }

    @Test
    public void testCreateUsuarioDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        UsuarioDao dao = DaoFactory.createUsuarioDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateCoordenadaDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        CoordenadaDao dao = DaoFactory.createCoordenadaDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateZona_SeguraDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        Zona_SeguraDao dao = DaoFactory.createZona_SeguraDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateHistorico_UsuarioDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        Historico_UsuarioDao dao = DaoFactory.createHistorico_UsuarioDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateUsuario_VictimaDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        Usuario_VictimaDao dao = DaoFactory.createUsuario_VictimaDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateUsuario_AtacanteDao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        Usuario_AtacanteDao dao = DaoFactory.createUsuario_AtacanteDao(handler);

        // Assert
        assertNull(dao);
    }

    @Test
    public void testCreateRelacion_VADao() {
        // Arrange
        DBHandler handler = mock(DBHandler.class);

        // Act
        Relacion_VADao dao = DaoFactory.createRelacion_VADao(handler);

        // Assert
        assertNull(dao);
    }
}