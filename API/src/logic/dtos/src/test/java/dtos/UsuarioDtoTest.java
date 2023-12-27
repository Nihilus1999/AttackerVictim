package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioDtoTest {

    @Test
    public void testGetSetNombre() {
        String nombre = "John";
        UsuarioDto dto = new UsuarioDto();
        dto.set_nombre(nombre);

        Assert.assertEquals(nombre, dto.get_nombre());
    }

    @Test
    public void testGetSetApellido() {
        String apellido = "Doe";
        UsuarioDto dto = new UsuarioDto();
        dto.set_apellido(apellido);

        Assert.assertEquals(apellido, dto.get_apellido());
    }

    @Test
    public void testGetSetAlias() {
        String alias = "johndoe";
        UsuarioDto dto = new UsuarioDto();
        dto.set_alias(alias);

        Assert.assertEquals(alias, dto.get_alias());
    }

    @Test
    public void testGetSetCedula() {
        String cedula = "1234567890";
        UsuarioDto dto = new UsuarioDto();
        dto.set_cedula(cedula);

        Assert.assertEquals(cedula, dto.get_cedula());
    }

    @Test
    public void testGetSetCorreo() {
        String correo = "john.doe@example.com";
        UsuarioDto dto = new UsuarioDto();
        dto.set_correo(correo);

        Assert.assertEquals(correo, dto.get_correo());
    }

    @Test
    public void testGetSetDireccionMac() {
        String direccionMac = "00:11:22:33:44:55";
        UsuarioDto dto = new UsuarioDto();
        dto.set_direccion_mac(direccionMac);

        Assert.assertEquals(direccionMac, dto.get_direccion_mac());
    }

    @Test
    public void testGetSetClave() {
        String clave = "secreto";
        UsuarioDto dto = new UsuarioDto();
        dto.set_clave(clave);

        Assert.assertEquals(clave, dto.get_clave());
    }

    @Test
    public void testGetSetActivate() {
        Boolean activate = true;
        UsuarioDto dto = new UsuarioDto();
        dto.set_activate(activate);

        Assert.assertEquals(activate, dto.get_activate());
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        UsuarioDto dto = new UsuarioDto(id);

        Assert.assertEquals(id, dto.getId());
    }

    @Test
    public void testConstructorWithoutIdParameter() {
        UsuarioDto dto = new UsuarioDto();

        Assert.assertEquals(0L, dto.getId());
    }
}