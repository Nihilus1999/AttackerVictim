package entities;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Usuario_AtacanteTest {

    @Test
    public void testConstructor() {
        // Arrange
        Usuario_Atacante usuarioAtacante;

        // Act
        usuarioAtacante = new Usuario_Atacante();

        // Assert
        assertNotNull(usuarioAtacante);
    }

    @Test
    public void testConstructorWithUsuario_AtacanteParameter() {
        // Arrange
        Usuario_Atacante usuarioAtacanteParam = new Usuario_Atacante();
        usuarioAtacanteParam.set_id(1);
        Usuario usuario = new Usuario();
        usuarioAtacanteParam.set_usuario(usuario);

        // Act
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante(usuarioAtacanteParam);
        usuarioAtacante.set_id(1);
        usuarioAtacante.set_usuario(usuario);

        // Assert
        assertNotNull(usuarioAtacante);
        assertEquals(usuarioAtacanteParam.get_id(), usuarioAtacante.get_id());
        assertEquals(usuarioAtacanteParam.get_usuario(), usuarioAtacante.get_usuario());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;
        Usuario_Atacante usuarioAtacante;

        // Act
        usuarioAtacante = new Usuario_Atacante(id);

        // Assert
        assertNotNull(usuarioAtacante);
        assertEquals(id, usuarioAtacante.get_id());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        long id = 1;
        Usuario usuario = new Usuario();

        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();

        // Act
        usuarioAtacante.set_id(id);
        usuarioAtacante.set_usuario(usuario);

        // Assert
        assertEquals(id, usuarioAtacante.get_id());
        assertEquals(usuario, usuarioAtacante.get_usuario());
    }
}

