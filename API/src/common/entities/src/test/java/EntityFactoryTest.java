import com.ucab.cmcapp.common.EntityFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactoryTest {

    // ADMINISTRADOR

    @Test
    public void testCreateAdministrador() {
        Administrador administrador = EntityFactory.createAdministrador();
        assertNotNull(administrador);
    }

    @Test
    public void testCreateAdministradorWithId() {
        long id = 1;
        Administrador administrador = EntityFactory.createAdministrador(id);
        assertNotNull(administrador);
        assertEquals(id, administrador.get_id());
    }

    // USUARIO

    @Test
    public void testCreateUsuario() {
        Usuario usuario = EntityFactory.createUsuario();
        assertNotNull(usuario);
    }

    @Test
    public void testCreateUsuarioWithId() {
        long id = 1;
        Usuario usuario = EntityFactory.createUsuario(id);
        assertNotNull(usuario);
        assertEquals(id, usuario.get_id());
    }

    // HISTORICO_USUARIO

    @Test
    public void testCreateHistoricoUsuario() {
        Historico_Usuario historicoUsuario = EntityFactory.createHistorico_Usuario();
        assertNotNull(historicoUsuario);
    }

    @Test
    public void testCreateHistoricoUsuarioWithId() {
        long id = 1;
        Historico_Usuario historicoUsuario = EntityFactory.createHistorico_Usuario(id);
        assertNotNull(historicoUsuario);
        assertEquals(id, historicoUsuario.get_id());
    }

    // USUARIO_VICTIMA

    @Test
    public void testCreateUsuarioVictima() {
        Usuario_Victima usuarioVictima = EntityFactory.createUsuario_Victima();
        assertNotNull(usuarioVictima);
    }

    @Test
    public void testCreateUsuarioVictimaWithId() {
        long id = 1;
        Usuario_Victima usuarioVictima = EntityFactory.createUsuario_Victima(id);
        assertNotNull(usuarioVictima);
        assertEquals(id, usuarioVictima.get_id());
    }

    // USUARIO_ATACANTE

    @Test
    public void testCreateUsuarioAtacante() {
        Usuario_Atacante usuarioAtacante = EntityFactory.createUsuario_Atacante();
        assertNotNull(usuarioAtacante);
    }

    @Test
    public void testCreateUsuarioAtacanteWithId() {
        long id = 1;
        Usuario_Atacante usuarioAtacante = EntityFactory.createUsuario_Atacante(id);
        assertNotNull(usuarioAtacante);
        assertEquals(id, usuarioAtacante.get_id());
    }

    // RELACION_VICTIMA-ATACANTE

    @Test
    public void testCreateRelacionVA() {
        Relacion_VA relacionVA = EntityFactory.createRelacion_VA();
        assertNotNull(relacionVA);
    }

    @Test
    public void testCreateRelacionVAWithId() {
        long id = 1;
        Relacion_VA relacionVA = EntityFactory.createRelacion_VA(id);
        assertNotNull(relacionVA);
        assertEquals(id, relacionVA.get_id());
    }

    // ZONA_SEGURA

    @Test
    public void testCreateZonaSegura() {
        Zona_Segura zonaSegura = EntityFactory.createZona_Segura();
        assertNotNull(zonaSegura);
    }

    @Test
    public void testCreateZonaSeguraWithId() {
        long id = 1;
        Zona_Segura zonaSegura = EntityFactory.createZona_Segura(id);
        assertNotNull(zonaSegura);
        assertEquals(id, zonaSegura.get_id());
    }

    // COORDENADAS

    @Test
    public void testCreateCoordenada() {
        Coordenada coordenada = EntityFactory.createCoordenada();
        assertNotNull(coordenada);
    }

    @Test
    public void testCreateCoordenadaWithId() {
        long id = 1;
        Coordenada coordenada = EntityFactory.createCoordenada(id);
        assertNotNull(coordenada);
        assertEquals(id, coordenada.get_id());
    }

    //NOTIFICACION

    @Test
    public void testCreateNotificacion() {
        // Arrange
        Notificacion notificacion;

        // Act
        notificacion = EntityFactory.createNotificacion();

        // Assert
        assertNotNull(notificacion);
        assertEquals(0, notificacion.get_id());
        assertNull(notificacion.get_tipo());
        assertNull(notificacion.get_descripcion());
        assertNull(notificacion.get_usuario());
    }

    @Test
    public void testCreateNotificacionWithId() {
        // Arrange
        long id = 1;
        Notificacion notificacion;

        // Act
        notificacion = EntityFactory.createNotificacion(id);

        // Assert
        assertNotNull(notificacion);
        assertEquals(id, notificacion.get_id());
        assertNull(notificacion.get_tipo());
        assertNull(notificacion.get_descripcion());
        assertNull(notificacion.get_usuario());
    }
}