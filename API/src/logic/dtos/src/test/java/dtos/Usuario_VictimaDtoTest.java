package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import org.junit.Assert;
import org.junit.Test;

public class Usuario_VictimaDtoTest {

    @Test
    public void testGetSetUsuario() {
        UsuarioDto usuarioDto = new UsuarioDto();
        Usuario_VictimaDto dto = new Usuario_VictimaDto();
        dto.set_usuario(usuarioDto);

        Assert.assertEquals(usuarioDto, dto.get_usuario());
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        Usuario_VictimaDto dto = new Usuario_VictimaDto(id);

        Assert.assertEquals(id, dto.getId());
    }

    @Test
    public void testConstructorWithoutIdParameter() {
        Usuario_VictimaDto dto = new Usuario_VictimaDto();

        Assert.assertEquals(0L, dto.getId());
    }
}
