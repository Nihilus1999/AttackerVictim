package entities;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Relacion_VATest {

    @Test
    public void testConstructor() {
        // Arrange & Act
        Relacion_VA relacionVA = new Relacion_VA();

        // Assert
        assertNotNull(relacionVA);
    }

    @Test
    public void testConstructorWithRelacionVAParameter() {
        // Arrange
        Relacion_VA usuario = new Relacion_VA();
        usuario.set_distancia(10.5f);

        // Act
        Relacion_VA relacionVA = new Relacion_VA(usuario);

        // Assert
        assertNotNull(relacionVA);
        assertEquals(usuario.get_distancia(), relacionVA.get_distancia());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;

        // Act
        Relacion_VA relacionVA = new Relacion_VA(id);

        // Assert
        assertNotNull(relacionVA);
        assertEquals(id, relacionVA.get_id());
    }

    @Test
    public void testGetSetId() {
        // Arrange
        long id = 1;
        Relacion_VA relacionVA = new Relacion_VA();

        // Act
        relacionVA.set_id(id);

        // Assert
        assertEquals(id, relacionVA.get_id());
    }

    @Test
    public void testGetSetDistancia() {
        // Arrange
        float distancia = 10.5f;
        Relacion_VA relacionVA = new Relacion_VA();

        // Act
        relacionVA.set_distancia(distancia);

        // Assert
        assertEquals(distancia, relacionVA.get_distancia());
    }

    @Test
    public void testGetSetTiempo() {
        // Arrange
        int tiempo = 5;
        Relacion_VA relacionVA = new Relacion_VA();

        // Act
        relacionVA.set_tiempo(tiempo);

        // Assert
        assertEquals(tiempo, relacionVA.get_tiempo());
    }

    @Test
    public void testGetSetUsuarioVictima() {
        // Arrange
        Usuario_Victima usuarioVictima = new Usuario_Victima();
        Relacion_VA relacionVA = new Relacion_VA();

        // Act
        relacionVA.set_usuario_victima(usuarioVictima);

        // Assert
        assertEquals(usuarioVictima, relacionVA.get_usuario_victima());
    }

    @Test
    public void testGetSetUsuarioAtacante() {
        // Arrange
        Usuario_Atacante usuarioAtacante = new Usuario_Atacante();
        Relacion_VA relacionVA = new Relacion_VA();

        // Act
        relacionVA.set_usuario_atacante(usuarioAtacante);

        // Assert
        assertEquals(usuarioAtacante, relacionVA.get_usuario_atacante());
    }
}