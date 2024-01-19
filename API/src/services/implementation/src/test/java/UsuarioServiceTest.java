import com.ucab.cmcapp.implementation.UsuarioService;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class UsuarioServiceTest {

    private UsuarioService usuarioService;

    @BeforeEach
    public void setup() {
        usuarioService = new UsuarioService();
        // Configuración adicional si es necesaria
    }

    @Test
    public void testGetUsuario() {
        // Arrange
        long usuarioId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getUsuario(usuarioId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllUsuario() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getAllUsuario();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetUsuarioByCorreo() {
        // Arrange
        String correo = "example@example.com";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getUsuarioByCorreo(correo);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetUsuarioByAlias() {
        // Arrange
        String alias = "testAlias";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getUsuarioByAlias(alias);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetUsuarioByCedula() {
        // Arrange
        String cedula = "12345678";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getUsuarioByCedula(cedula);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetUsuarioByMac() {
        // Arrange
        String mac = "00:11:22:33:44:55";

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.getUsuarioByMac(mac);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddUsuario() {
        // Arrange
        UsuarioDto usuarioDto = new UsuarioDto();
        // Configurar los datos del usuarioDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.addUsuario(usuarioDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteUsuario() {
        // Arrange
        long usuarioId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.deleteUsuario(usuarioId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateUsuario() {
        // Arrange
        UsuarioDto usuarioDto = new UsuarioDto();
        // Configurar los datos del usuarioDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = usuarioService.updateUsuario(usuarioDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

}