package entities;

import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Historico_UsuarioTest {

    @Test
    public void testGetAndSetMethods() {
        // Arrange
        Usuario usuarioMock = mock(Usuario.class);

        Historico_Usuario historico = new Historico_Usuario();
        historico.set_id(1);
        historico.set_fecha(new Date());
        historico.set_estadoConexion(true);
        historico.set_latitud(10.0f);
        historico.set_longitud(20.0f);
        historico.set_usuario(usuarioMock);

        // Act & Assert
        assertEquals(1, historico.get_id());
        assertEquals(true, historico.get_estadoConexion());
        assertEquals(10.0f, historico.get_latitud());
        assertEquals(20.0f, historico.get_longitud());
        assertEquals(usuarioMock, historico.get_usuario());
    }

    @Test
    public void testConstructor() {
        // Arrange
        Historico_Usuario historicoOriginal = new Historico_Usuario();
        historicoOriginal.set_fecha(new Date());
        historicoOriginal.set_estadoConexion(true);
        historicoOriginal.set_latitud(10.0f);
        historicoOriginal.set_longitud(20.0f);

        // Act
        Historico_Usuario historicoCopia = new Historico_Usuario(historicoOriginal);

        // Assert
        assertEquals(true, historicoCopia.get_estadoConexion());
        assertEquals(10.0f, historicoCopia.get_latitud());
        assertEquals(20.0f, historicoCopia.get_longitud());
        assertEquals(new Date(), historicoCopia.get_fecha());
    }

    @Test
    public void testIdConstructor() {
        // Arrange & Act
        Historico_Usuario historico = new Historico_Usuario(1);

        // Assert
        assertEquals(1, historico.get_id());
    }
}