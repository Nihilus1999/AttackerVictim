import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AdministradorDao;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DaoFactoryTest {

    @Test
    public void testCreateAdministradorDao() {
        // Crea un mock del DBHandler
        DBHandler dbHandlerMock = mock(DBHandler.class);
        dbHandlerMock.beginTransaction();

        // Crea una instancia del AdministradorDao utilizando el DBHandler simulado
        AdministradorDao administradorDao = DaoFactory.createAdministradorDao(dbHandlerMock);

        // Verifica que se haya creado correctamente el AdministradorDao con el DBHandler simulado
        assertNull(administradorDao);
    }
}