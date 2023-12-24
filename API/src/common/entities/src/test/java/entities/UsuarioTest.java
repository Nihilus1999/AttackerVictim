package entities;

import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testConstructor() {
        // Arrange
        Usuario usuario;

        // Act
        usuario = new Usuario();

        // Assert
        assertNotNull(usuario);
    }

    @Test
    public void testConstructorWithUsuarioParameter() {
        // Arrange
        Usuario usuarioParam = new Usuario();
        usuarioParam.set_nombre("John");
        usuarioParam.set_apellido("Doe");
        usuarioParam.set_alias("johndoe");
        usuarioParam.set_cedula("123456789");
        usuarioParam.set_correo("john.doe@example.com");
        usuarioParam.set_direccion_mac("00:11:22:33:44:55");
        usuarioParam.set_clave("password");
        usuarioParam.set_activate(true);
        Usuario usuario;

        // Act
        usuario = new Usuario(usuarioParam);

        // Assert
        assertNotNull(usuario);
        assertEquals(usuarioParam.get_nombre(), usuario.get_nombre());
        assertEquals(usuarioParam.get_apellido(), usuario.get_apellido());
        assertEquals(usuarioParam.get_alias(), usuario.get_alias());
        assertEquals(usuarioParam.get_cedula(), usuario.get_cedula());
        assertEquals(usuarioParam.get_correo(), usuario.get_correo());
        assertEquals(usuarioParam.get_direccion_mac(), usuario.get_direccion_mac());
        assertEquals(usuarioParam.get_clave(), usuario.get_clave());
        assertEquals(usuarioParam.get_activate(), usuario.get_activate());
    }

    @Test
    public void testConstructorWithId() {
        // Arrange
        long id = 1;
        Usuario usuario;

        // Act
        usuario = new Usuario(id);

        // Assert
        assertNotNull(usuario);
        assertEquals(id, usuario.get_id());
    }

    @Test
    public void testConstructorWithAlias() {
        // Arrange
        String alias = "johndoe";
        Usuario usuario;

        // Act
        usuario = new Usuario(alias);

        // Assert
        assertNotNull(usuario);
        assertEquals(alias, usuario.get_alias());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        long id = 1;
        String nombre = "John";
        String apellido = "Doe";
        String alias = "johndoe";
        String cedula = "123456789";
        String correo = "john.doe@example.com";
        String direccionMac = "00:11:22:33:44:55";
        String clave = "password";
        Boolean activate = true;
        Usuario usuario = new Usuario();

        // Act
        usuario.set_id(id);
        usuario.set_nombre(nombre);
        usuario.set_apellido(apellido);
        usuario.set_alias(alias);
        usuario.set_cedula(cedula);
        usuario.set_correo(correo);
        usuario.set_direccion_mac(direccionMac);
        usuario.set_clave(clave);
        usuario.set_activate(activate);

        // Assert
        assertEquals(id, usuario.get_id());
        assertEquals(nombre, usuario.get_nombre());
        assertEquals(apellido, usuario.get_apellido());
        assertEquals(alias, usuario.get_alias());
        assertEquals(cedula, usuario.get_cedula());
        assertEquals(correo, usuario.get_correo());
        assertEquals(direccionMac, usuario.get_direccion_mac());
        assertEquals(clave, usuario.get_clave());
        assertEquals(activate, usuario.get_activate());
    }
}