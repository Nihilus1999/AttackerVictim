package dtos;

import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import org.junit.Assert;
import org.junit.Test;

public class CoordenadaDtoTest {

    @Test
    public void testGetSetLatitud() {
        double latitud = 10.5;
        CoordenadaDto dto = new CoordenadaDto();
        dto.set_latitud(latitud);

        Assert.assertEquals(latitud, dto.get_latitud(), 0.001);
    }

    @Test
    public void testGetSetLongitud() {
        double longitud = -66.9;
        CoordenadaDto dto = new CoordenadaDto();
        dto.set_longitud(longitud);

        Assert.assertEquals(longitud, dto.get_longitud(), 0.001);
    }

    @Test
    public void testConstructorWithIdParameter() {
        long id = 1L;
        CoordenadaDto coordenada = new CoordenadaDto(id);

        Assert.assertEquals(id, coordenada.getId());
    }

    @Test
    public void testGetSetZonaSegura() {
        Zona_SeguraDto zonaSeguraDto = new Zona_SeguraDto();
        CoordenadaDto dto = new CoordenadaDto();
        dto.set_zona_segura(zonaSeguraDto);

        Assert.assertEquals(zonaSeguraDto, dto.get_zona_segura());
    }
}
