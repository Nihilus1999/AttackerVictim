package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.NotificacionDto;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotificacionDtoTest {

    @Test
    public void testConstructorWithId() {
        // Arrange
        long expectedId = 123;

        // Act
        NotificacionDto notificacionDto = new NotificacionDto(expectedId);

        // Assert
        assertEquals(expectedId, notificacionDto.getId());
        assertNull(notificacionDto.get_tipo());
        assertNull(notificacionDto.get_descripcion());
        assertNull(notificacionDto.get_usuario());
    }

    @Test
    public void testGetSetTipo() {
        // Arrange
        String expectedTipo = "Notificación";

        // Act
        NotificacionDto notificacionDto = new NotificacionDto();
        notificacionDto.set_tipo(expectedTipo);
        String tipo = notificacionDto.get_tipo();

        // Assert
        assertEquals(expectedTipo, tipo);
    }

    @Test
    public void testGetSetDescripcion() {
        // Arrange
        String expectedDescripcion = "Descripción de la notificación";

        // Act
        NotificacionDto notificacionDto = new NotificacionDto();
        notificacionDto.set_descripcion(expectedDescripcion);
        String descripcion = notificacionDto.get_descripcion();

        // Assert
        assertEquals(expectedDescripcion, descripcion);
    }

    @Test
    public void testGetSetUsuario() {
        // Arrange
        UsuarioDto expectedUsuario = new UsuarioDto();

        // Act
        NotificacionDto notificacionDto = new NotificacionDto();
        notificacionDto.set_usuario(expectedUsuario);
        UsuarioDto usuario = notificacionDto.get_usuario();

        // Assert
        assertEquals(expectedUsuario, usuario);
    }
}
