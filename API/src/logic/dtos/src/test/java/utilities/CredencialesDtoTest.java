package utilities;

import com.ucab.cmcapp.logic.dtos.extras.CredencialesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredencialesDtoTest {

    @Test
    public void testConstructorSinParametros() {
        // Arrange
        CredencialesDto credenciales = new CredencialesDto();

        // Act and Assert
        Assertions.assertNull(credenciales.get_alias());
        Assertions.assertNull(credenciales.get_clave());
    }

    @Test
    public void testConstructorConParametros() {
        // Arrange
        String alias = "john_doe";
        String clave = "password123";
        CredencialesDto credenciales = new CredencialesDto(alias, clave);

        // Act and Assert
        Assertions.assertEquals(alias, credenciales.get_alias());
        Assertions.assertEquals(clave, credenciales.get_clave());
    }

    @Test
    public void testSetAlias() {
        // Arrange
        String alias = "john_doe";
        CredencialesDto credenciales = new CredencialesDto();

        // Act
        credenciales.set_alias(alias);

        // Assert
        Assertions.assertEquals(alias, credenciales.get_alias());
    }

    @Test
    public void testSetClave() {
        // Arrange
        String clave = "password123";
        CredencialesDto credenciales = new CredencialesDto();

        // Act
        credenciales.set_clave(clave);

        // Assert
        Assertions.assertEquals(clave, credenciales.get_clave());
    }
}


