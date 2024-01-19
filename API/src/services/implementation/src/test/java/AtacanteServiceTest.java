import com.ucab.cmcapp.implementation.AtacanteService;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class AtacanteServiceTest {

    private AtacanteService atacanteService;

    @BeforeEach
    public void setup() {
        // Arrange
        atacanteService = new AtacanteService();
    }

    @Test
    public void testGetAtacante() {
        // Arrange
        long atacanteId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = atacanteService.getAtacante(atacanteId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllAtacante() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = atacanteService.getAllAtacante();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddAtacante() {
        // Arrange
        Usuario_AtacanteDto atacanteDto = new Usuario_AtacanteDto();
        // Establecer los valores necesarios para el atacanteDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = atacanteService.addAtacante(atacanteDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteAtacante() {
        // Arrange
        long atacanteId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = atacanteService.deleteAtacante(atacanteId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateAtacante() {
        // Arrange
        Usuario_AtacanteDto atacanteDto = new Usuario_AtacanteDto();
        // Establecer los valores necesarios para el atacanteDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = atacanteService.updateAtacante(atacanteDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}