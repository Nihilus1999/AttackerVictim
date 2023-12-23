package entities;

import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.common.entities.Coordenada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdministradorTest {

    @Test
    public void testGetAndSetMethods() {
        // Arrange
        Administrador administrador = new Administrador();
        administrador.set_id(1);
        administrador.set_alias("admin");
        administrador.set_correo("admin@example.com");
        administrador.set_clave("password");

        // Act & Assert
        assertEquals(1, administrador.get_id());
        assertEquals("admin", administrador.get_alias());
        assertEquals("admin@example.com", administrador.get_correo());
        assertEquals("password", administrador.get_clave());
    }

    @Test
    public void testConstructor() {
        // Arrange
        Administrador administradorOriginal = new Administrador();
        administradorOriginal.set_alias("Nihilus");
        administradorOriginal.set_correo("jose@gmail.com");
        administradorOriginal.set_clave("3110");

        // Act
        Administrador administradorCopia = new Administrador(administradorOriginal);

        // Assert
        assertEquals("Nihilus", administradorCopia.get_alias());
        assertEquals("jose@gmail.com", administradorCopia.get_correo());
        assertEquals("3110", administradorCopia.get_clave());
    }

    @Test
    public void testIdConstructor() {
        // Arrange & Act
        Administrador administrador = new Administrador(5);

        // Assert
        assertEquals(5, administrador.get_id());
    }

    @Test
    public void testAliasConstructor() {
        // Arrange & Act
        Administrador administrador = new Administrador("admin");

        // Assert
        assertEquals("admin", administrador.get_alias());
    }
}