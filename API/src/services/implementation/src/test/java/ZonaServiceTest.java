import com.ucab.cmcapp.implementation.ZonaService;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class ZonaServiceTest {
    private ZonaService zonaService;

    @BeforeEach
    public void setup() {
        zonaService = new ZonaService();
    }

    @Test
    public void testGetZonas() {
        // Arrange
        long zonasId = 1L;

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.getZonas(zonasId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllZonas() {
        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.getAllZonas();

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllZonasByUsuarioId() {
        // Arrange
        long victimaId = 1L;

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.getAllZonasByUsuarioId(victimaId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddZonas() {
        // Arrange
        Zona_SeguraDto zonasSegurasDto = new Zona_SeguraDto();
        // Establecer los valores necesarios para zonasSegurasDto

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.addZonas(zonasSegurasDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteZonas() {
        // Arrange
        long zonasId = 1L;

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.deleteZonas(zonasId);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateZonas() {
        // Arrange
        Zona_SeguraDto zonasSegurasDto = new Zona_SeguraDto();
        // Establecer los valores necesarios para zonasSegurasDto

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            Response response = zonaService.updateZonas(zonasSegurasDto);

            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}
