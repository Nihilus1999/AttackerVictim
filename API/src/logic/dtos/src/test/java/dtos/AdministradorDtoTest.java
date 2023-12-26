package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdministradorDtoTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        long id = 1L;
        String alias = "admin";
        String correo = "admin@example.com";
        String clave = "password123";

        // Act
        AdministradorDto administradorDto = new AdministradorDto(id);
        administradorDto.set_alias(alias);
        administradorDto.set_correo(correo);
        administradorDto.set_clave(clave);

        // Assert
        assertEquals(id, administradorDto.getId());
        assertEquals(alias, administradorDto.get_alias());
        assertEquals(correo, administradorDto.get_correo());
        assertEquals(clave, administradorDto.get_clave());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        AdministradorDto administradorDto = new AdministradorDto();

        // Act
        administradorDto.set_alias("admin");
        administradorDto.set_correo("admin@example.com");
        administradorDto.set_clave("password123");

        // Assert
        assertEquals("admin", administradorDto.get_alias());
        assertEquals("admin@example.com", administradorDto.get_correo());
        assertEquals("password123", administradorDto.get_clave());
    }
}