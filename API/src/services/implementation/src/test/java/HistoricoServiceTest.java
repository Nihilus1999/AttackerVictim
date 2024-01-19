import com.ucab.cmcapp.implementation.HistoricoService;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class HistoricoServiceTest {

    private HistoricoService historicoService;

    @BeforeEach
    public void setup() {
        // Arrange
        historicoService = new HistoricoService();
    }

    @Test
    public void testGetHistorico() {
        // Arrange
        long historicoId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.getHistorico(historicoId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllHistorico() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.getAllHistorico();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllHistoricoByUsuarioId() {
        // Arrange
        long usuarioId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.getAllHistoricoByUsuarioId(usuarioId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddHistorico() {
        // Arrange
        Historico_UsuarioDto historicoUsuarioDto = new Historico_UsuarioDto();
        // Establecer los valores necesarios para el historicoUsuarioDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.addHistorico(historicoUsuarioDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteHistorico() {
        // Arrange
        long historicoId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.deleteHistorico(historicoId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateHistorico() {
        // Arrange
        Historico_UsuarioDto historicoUsuarioDto = new Historico_UsuarioDto();
        // Establecer los valores necesarios para el historicoUsuarioDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = historicoService.updateHistorico(historicoUsuarioDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}
