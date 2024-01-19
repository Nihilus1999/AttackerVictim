package entities;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Usuario_VictimaTest {

    @Test
    public void testConstructor() {
        // Arrange
        Usuario_Victima usuarioVictima;

        // Act
        usuarioVictima = new Usuario_Victima();

        // Assert
        assertNotNull(usuarioVictima);
    }

    @Test
    public void testConstructorWithUsuario_VictimaParameter() {
        // Arrange
        Usuario_Victima usuarioVictimaParam = new Usuario_Victima();
        usuarioVictimaParam.set_id(1);
        Usuario usuario = new Usuario();
        usuarioVictimaParam.set_usuario(usuario);

        // Act
        Usuario_Victima usuarioVictima = new Usuario_Victima(usuarioVictimaParam);
        usuarioVictima.set_id(1);
        usuarioVictima.set_usuario(usuario);

        // Assert
        assertNotNull(usuarioVictima);
        assertEquals(usuarioVictimaParam.get_id(), usuarioVictima.get_id());
        assertEquals(usuarioVictimaParam.get_usuario(), usuarioVictima.get_usuario());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;
        Usuario_Victima usuarioVictima;

        // Act
        usuarioVictima = new Usuario_Victima(id);

        // Assert
        assertNotNull(usuarioVictima);
        assertEquals(id, usuarioVictima.get_id());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        long id = 1;
        Usuario usuario = new Usuario();

        Usuario_Victima usuarioVictima = new Usuario_Victima();

        // Act
        usuarioVictima.set_id(id);
        usuarioVictima.set_usuario(usuario);

        // Assert
        assertEquals(id, usuarioVictima.get_id());
        assertEquals(usuario, usuarioVictima.get_usuario());
    }
}