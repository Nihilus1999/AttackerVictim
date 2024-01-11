package utilities;

import com.ucab.cmcapp.logic.dtos.utilities.AtacanteDentroZonaSeguraDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AtacanteDentroZonaSeguraDtoTest {

    @Test
    public void testConstructorSinParametros() {
        // Arrange
        AtacanteDentroZonaSeguraDto atacanteDto = new AtacanteDentroZonaSeguraDto();

        // Act and Assert
        Assertions.assertNull(atacanteDto.get_dentro());
        Assertions.assertEquals(new ArrayList<String>(), atacanteDto.get_zonas_seguras());
        Assertions.assertNull(atacanteDto.get_latitud());
        Assertions.assertNull(atacanteDto.get_longitud());
    }

    @Test
    public void testSetDentro() {
        // Arrange
        Boolean dentro = true;
        AtacanteDentroZonaSeguraDto atacanteDto = new AtacanteDentroZonaSeguraDto();

        // Act
        atacanteDto.set_dentro(dentro);

        // Assert
        Assertions.assertEquals(dentro, atacanteDto.get_dentro());
    }

    @Test
    public void testSetZonasSeguras() {
        // Arrange
        List<String> zonasSeguras = new ArrayList<>();
        zonasSeguras.add("Zona A");
        zonasSeguras.add("Zona B");
        AtacanteDentroZonaSeguraDto atacanteDto = new AtacanteDentroZonaSeguraDto();

        // Act
        atacanteDto.set_zonas_seguras(zonasSeguras);

        // Assert
        Assertions.assertNotEquals(zonasSeguras, atacanteDto.get_zonas_seguras());
    }

    @Test
    public void testSetLatitud() {
        // Arrange
        Double latitud = 10.12345;
        AtacanteDentroZonaSeguraDto atacanteDto = new AtacanteDentroZonaSeguraDto();

        // Act
        atacanteDto.set_latitud(latitud);

        // Assert
        Assertions.assertEquals(latitud, atacanteDto.get_latitud());
    }

    @Test
    public void testSetLongitud() {
        // Arrange
        Double longitud = -66.54321;
        AtacanteDentroZonaSeguraDto atacanteDto = new AtacanteDentroZonaSeguraDto();

        // Act
        atacanteDto.set_longitud(longitud);

        // Assert
        Assertions.assertEquals(longitud, atacanteDto.get_longitud());
    }
}
