package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class Historico_UsuarioDtoTest {

    @Test
    public void testGetSetFecha() {
        Date fecha = new Date();
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.set_fecha(fecha);

        Assert.assertEquals(fecha, dto.get_fecha());
    }

    @Test
    public void testGetSetEstadoConexion() {
        Boolean estadoConexion = true;
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.set_estadoConexion(estadoConexion);

        Assert.assertEquals(estadoConexion, dto.get_estadoConexion());
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        Historico_UsuarioDto historicoUsuario = new Historico_UsuarioDto(id);

        Assert.assertEquals(id, historicoUsuario.getId());
    }

    @Test
    public void testGetSetLatitud() {
        double latitud = 10.5;
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.set_latitud(latitud);

        Assert.assertEquals(latitud, dto.get_latitud(), 0.001);
    }

    @Test
    public void testGetSetLongitud() {
        double longitud = -66.9;
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.set_longitud(longitud);

        Assert.assertEquals(longitud, dto.get_longitud(), 0.001);
    }

    @Test
    public void testGetSetUsuario() {
        UsuarioDto usuarioDto = new UsuarioDto();
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.set_usuario(usuarioDto);

        Assert.assertEquals(usuarioDto, dto.get_usuario());
    }
}
