import com.ucab.cmcapp.implementation.RelacionService;
import com.ucab.cmcapp.logic.dtos.dtos.Relacion_VADto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class RelacionServiceTest {
    private RelacionService relacionService;

    @BeforeEach
    public void setup() {
        relacionService = new RelacionService();
    }

    @Test
    public void testGetRelacion() {
        // Arrange
        long relacionId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = relacionService.getRelacion(relacionId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllRelacion() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = relacionService.getAllRelacion();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddRelacion() {
        // Arrange
        Relacion_VADto relacionDto = new Relacion_VADto();
        // Establecer los valores necesarios para el relacionDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = relacionService.addRelacion(relacionDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteRelacion() {
        // Arrange
        long relacionId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = relacionService.deleteRelacion(relacionId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateRelacion() {
        // Arrange
        Relacion_VADto relacionDto = new Relacion_VADto();
        // Establecer los valores necesarios para el relacionDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = relacionService.updateRelacion(relacionDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}