package entities;

import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificacionTest {

    @Test
    public void testConstructorDefault() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Assert
        assertNull(notificacion.get_tipo());
        assertNull(notificacion.get_descripcion());
        assertNull(notificacion.get_usuario());
    }

    @Test
    public void testConstructorWithNotificacion() {
        // Arrange
        Notificacion sourceNotificacion = new Notificacion();
        sourceNotificacion.set_tipo("Tipo");
        sourceNotificacion.set_descripcion("Descripción");

        // Act
        Notificacion notificacion = new Notificacion(sourceNotificacion);

        // Assert
        assertEquals("Tipo", notificacion.get_tipo());
        assertEquals("Descripción", notificacion.get_descripcion());
        assertNull(notificacion.get_usuario());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;

        // Act
        Notificacion notificacion = new Notificacion(id);

        // Assert
        assertEquals(id, notificacion.get_id());
        assertNull(notificacion.get_tipo());
        assertNull(notificacion.get_descripcion());
        assertNull(notificacion.get_usuario());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Notificacion notificacion = new Notificacion();

        // Act
        notificacion.set_id(1);
        notificacion.set_tipo("Tipo");
        notificacion.set_descripcion("Descripción");

        Usuario usuario = new Usuario();
        notificacion.set_usuario(usuario);

        // Assert
        assertEquals(1, notificacion.get_id());
        assertEquals("Tipo", notificacion.get_tipo());
        assertEquals("Descripción", notificacion.get_descripcion());
        assertEquals(usuario, notificacion.get_usuario());
    }
}
