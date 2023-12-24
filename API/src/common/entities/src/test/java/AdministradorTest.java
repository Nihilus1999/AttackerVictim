import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Coordenada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdministradorTest {

    @Test
    public void testGetAndSetMethods() {
        Administrador administrador = new Administrador();
        administrador.set_id(1);
        administrador.set_alias("admin");
        administrador.set_correo("admin@example.com");
        administrador.set_clave("password");

        assertEquals(1, administrador.get_id());
        assertEquals("admin", administrador.get_alias());
        assertEquals("admin@example.com", administrador.get_correo());
        assertEquals("password", administrador.get_clave());
    }

    @Test
    public void testConstructor() {
        Administrador administradorOriginal = new Administrador();
        administradorOriginal.set_alias("Nihilus");
        administradorOriginal.set_correo("jose@gmail.com");
        administradorOriginal.set_clave("3110");

        Administrador administradorCopia = new Administrador(administradorOriginal);
        assertEquals("Nihilus", administradorCopia.get_alias());
        assertEquals("jose@gmail.com", administradorCopia.get_correo());
        assertEquals("3110", administradorCopia.get_clave());
    }

    @Test
    public void testIdConstructor() {
        Administrador administrador = new Administrador(5);
        assertEquals(5, administrador.get_id());
    }

    @Test
    public void testAliasConstructor() {
        Administrador administrador = new Administrador("admin");
        assertEquals("admin", administrador.get_alias());
    }
}
