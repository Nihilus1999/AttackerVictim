package entities;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Zona_SeguraTest {

    @Test
    public void testConstructor() {
        // Arrange
        Zona_Segura zonaSegura;

        // Act
        zonaSegura = new Zona_Segura();

        // Assert
        assertNotNull(zonaSegura);
    }

    @Test
    public void testConstructorWithZonaSeguraParameter() {
        // Arrange
        Zona_Segura zonaSeguraParam = new Zona_Segura();
        zonaSeguraParam.set_id(1);
        zonaSeguraParam.set_nombre("Zona A");
        Usuario_Victima victima = new Usuario_Victima();
        zonaSeguraParam.set_victima(victima);
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        zonaSegura.set_id(1);
        zonaSegura.set_nombre("Zona A");
        zonaSegura.set_victima(victima);


        // Assert
        assertNotNull(zonaSegura);
        assertEquals(zonaSeguraParam.get_id(), zonaSegura.get_id());
        assertEquals(zonaSeguraParam.get_nombre(), zonaSegura.get_nombre());
        assertEquals(zonaSeguraParam.get_victima(), zonaSegura.get_victima());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;
        Zona_Segura zonaSegura;

        // Act
        zonaSegura = new Zona_Segura(id);

        // Assert
        assertNotNull(zonaSegura);
        assertEquals(id, zonaSegura.get_id());
    }

    @Test
    public void testConstructorWithNombre() {
        // Arrange
        String nombre = "Zona A";
        Zona_Segura usuarioParam = new Zona_Segura();
        usuarioParam.set_nombre(nombre);

        // Act
        Zona_Segura usuario = new Zona_Segura(usuarioParam);

        // Assert
        assertNotNull(usuario);
        assertEquals(nombre, usuario.get_nombre());
    }


    @Test
    public void testGettersAndSetters() {
        // Arrange
        long id = 1;
        String nombre = "Zona A";
        Usuario_Victima victima = new Usuario_Victima();
        Zona_Segura zonaSegura = new Zona_Segura();

        // Act
        zonaSegura.set_id(id);
        zonaSegura.set_nombre(nombre);
        zonaSegura.set_victima(victima);

        // Assert
        assertEquals(id, zonaSegura.get_id());
        assertEquals(nombre, zonaSegura.get_nombre());
        assertEquals(victima, zonaSegura.get_victima());
    }
}

