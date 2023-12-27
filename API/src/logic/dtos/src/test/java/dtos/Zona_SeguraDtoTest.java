package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import org.junit.Assert;
import org.junit.Test;

public class Zona_SeguraDtoTest {

    @Test
    public void testGetSetNombre() {
        String nombre = "Zona Segura 1";
        Zona_SeguraDto dto = new Zona_SeguraDto();
        dto.set_nombre(nombre);

        Assert.assertEquals(nombre, dto.get_nombre());
    }

    @Test
    public void testGetSetVictima() {
        Usuario_VictimaDto victima = new Usuario_VictimaDto();
        Zona_SeguraDto dto = new Zona_SeguraDto();
        dto.set_victima(victima);

        Assert.assertEquals(victima, dto.get_victima());
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        Zona_SeguraDto dto = new Zona_SeguraDto(id);

        Assert.assertEquals(id, dto.getId());
    }

    @Test
    public void testConstructorWithoutIdParameter() {
        Zona_SeguraDto dto = new Zona_SeguraDto();

        Assert.assertEquals(0L, dto.getId());
    }
}