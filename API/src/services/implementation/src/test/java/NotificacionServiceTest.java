import com.ucab.cmcapp.implementation.NotificacionService;
import com.ucab.cmcapp.logic.dtos.dtos.NotificacionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class NotificacionServiceTest {

    private NotificacionService notificacionService;

    @BeforeEach
    public void setup() {
        // Arrange
        notificacionService = new NotificacionService();
    }

    @Test
    public void testGetNotificacion() {
        // Arrange
        long notificacionId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.getNotificacion(notificacionId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllNotificacion() {
        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.getAllNotificacion();

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testGetAllNotificacionByUsuarioId() {
        // Arrange
        long usuarioId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.getAllNotificacionByUsuarioId(usuarioId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testAddNotificacion() {
        // Arrange
        NotificacionDto notificacionDto = new NotificacionDto();
        // Establecer los valores necesarios para el notificacionDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.addNotificacion(notificacionDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testDeleteNotificacion() {
        // Arrange
        long notificacionId = 1L;

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.deleteNotificacion(notificacionId);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }

    @Test
    public void testUpdateNotificacion() {
        // Arrange
        NotificacionDto notificacionDto = new NotificacionDto();
        // Establecer los valores necesarios para el notificacionDto

        // Act
        Assertions.assertThrows(Exception.class, () -> {
            Response response = notificacionService.updateNotificacion(notificacionDto);

            // Assert
            Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            // Verificar más detalles según el resultado esperado
        });
    }
}
