package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.Relacion_VADto;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import org.junit.Assert;
import org.junit.Test;

public class Relacion_VADtoTest {

    @Test
    public void testGetSetDistancia() {
        float distancia = 10.5f;
        Relacion_VADto dto = new Relacion_VADto();
        dto.set_distancia(distancia);

        Assert.assertEquals(distancia, dto.get_distancia(), 0.001);
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        Relacion_VADto relacionVA = new Relacion_VADto(id);

        Assert.assertEquals(id, relacionVA.getId());
    }

    @Test
    public void testGetSetUsuarioVictima() {
        Usuario_VictimaDto usuarioVictimaDto = new Usuario_VictimaDto();
        Relacion_VADto dto = new Relacion_VADto();
        dto.set_usuario_victima(usuarioVictimaDto);

        Assert.assertEquals(usuarioVictimaDto, dto.get_usuario_victima());
    }

    @Test
    public void testGetSetUsuarioAtacante() {
        Usuario_AtacanteDto usuarioAtacanteDto = new Usuario_AtacanteDto();
        Relacion_VADto dto = new Relacion_VADto();
        dto.set_usuario_atacante(usuarioAtacanteDto);

        Assert.assertEquals(usuarioAtacanteDto, dto.get_usuario_atacante());
    }
}
