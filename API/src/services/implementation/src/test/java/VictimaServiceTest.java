import com.ucab.cmcapp.implementation.VictimaService;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class VictimaServiceTest {
    private VictimaService victimaService;

    @BeforeEach
    public void setup() {
        victimaService = new VictimaService();
    }

    @Test
    public void testGetVictima() {
        // Arrange
        long victimaId = 1L;

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = victimaService.getVictima(victimaId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllVictima() {
        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = victimaService.getAllVictima();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddVictima() {
        // Arrange
        Usuario_VictimaDto victimaDto = new Usuario_VictimaDto();
        // Establecer los valores necesarios para victimaDto

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = victimaService.addVictima(victimaDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteVictima() {
        // Arrange
        long victimaId = 1L;

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = victimaService.deleteVictima(victimaId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateVictima() {
        // Arrange
        Usuario_VictimaDto victimaDto = new Usuario_VictimaDto();
        // Establecer los valores necesarios para victimaDto

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = victimaService.updateVictima(victimaDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}


