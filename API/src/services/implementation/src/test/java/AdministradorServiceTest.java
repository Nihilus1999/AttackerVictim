import com.ucab.cmcapp.implementation.AdministradorService;
import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class AdministradorServiceTest {
    private AdministradorService administradorService;

    @BeforeEach
    public void setUp() {
        // Arrange
        administradorService = new AdministradorService();
    }

    @Test
    public void testGetAdministrador() {
        // Arrange
        long adminId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.getAdministrador(adminId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllAdministrador() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.getAllAdministrador();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAdministradorByCorreo() {
        // Arrange
        String correo = "example@example.com";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.getAdministradorByCorreo(correo);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAdministradorByAlias() {
        // Arrange
        String alias = "admin";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.getAdministradorByAlias(alias);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddAdministrador() {
        // Arrange
        AdministradorDto administradorDto = new AdministradorDto();
        // Establecer los valores necesarios para el administradorDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.addAdministrador(administradorDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteAdministrador() {
        // Arrange
        long adminId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.deleteAdministrador(adminId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateAdministrador() {
        // Arrange
        AdministradorDto administradorDto = new AdministradorDto();
        // Establecer los valores necesarios para el administradorDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = administradorService.updateAdministrador(administradorDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}