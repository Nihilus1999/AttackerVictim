package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import org.junit.Assert;
import org.junit.Test;

public class Usuario_AtacanteDtoTest {

    @Test
    public void testGetSetUsuario() {
        UsuarioDto usuarioDto = new UsuarioDto();
        Usuario_AtacanteDto dto = new Usuario_AtacanteDto();
        dto.set_usuario(usuarioDto);

        Assert.assertEquals(usuarioDto, dto.get_usuario());
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        Usuario_AtacanteDto dto = new Usuario_AtacanteDto(id);

        Assert.assertEquals(id, dto.getId());
    }

    @Test
    public void testConstructorWithoutIdParameter() {
        Usuario_AtacanteDto dto = new Usuario_AtacanteDto();

        Assert.assertEquals(0L, dto.getId());
    }
}