package utilities;

import com.ucab.cmcapp.logic.dtos.dtos.Atacante_Dentro_Zona_SeguraDto;
import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import com.ucab.cmcapp.logic.dtos.utilities.determinarAtacanteZonaSegura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class determinarAtacanteZonaSeguraTest {

    private determinarAtacanteZonaSegura determinarAtacanteZonaSegura;
    private Historico_UsuarioDto lastAttackerCoordinate;
    private List<Zona_SeguraDto> posibleZones;
    private List<CoordenadaDto> posiblesCoordenadas;

    @BeforeEach
    public void setUp() {
        determinarAtacanteZonaSegura = new determinarAtacanteZonaSegura();
        lastAttackerCoordinate = new Historico_UsuarioDto();
        lastAttackerCoordinate.set_latitud(10.0);
        lastAttackerCoordinate.set_longitud(20.0);

        posibleZones = new ArrayList<>();
        Zona_SeguraDto zona1 = new Zona_SeguraDto();
        zona1.setId(1);
        zona1.set_nombre("Zona1");
        posibleZones.add(zona1);

        posiblesCoordenadas = new ArrayList<>();
        CoordenadaDto coordenada1 = new CoordenadaDto();
        coordenada1.set_zona_segura(zona1);
        coordenada1.set_latitud(10.0);
        coordenada1.set_longitud(20.0);
        posiblesCoordenadas.add(coordenada1);
    }

    @Test
    public void testVerifyAttackerInSafeZone() {
        // Arrange
        Atacante_Dentro_Zona_SeguraDto expectedDto = new Atacante_Dentro_Zona_SeguraDto();
        expectedDto.set_dentro(true);
        expectedDto.get_zonas_seguras().add("Zona1");
        expectedDto.set_latitud(10.0);
        expectedDto.set_longitud(20.0);

        // Act
        Atacante_Dentro_Zona_SeguraDto resultDto = determinarAtacanteZonaSegura.verifyAttackerInSafeZone(lastAttackerCoordinate, posibleZones, posiblesCoordenadas);

        // Assert
        assertNotNull(resultDto);
        assertNotEquals(expectedDto.get_dentro(), resultDto.get_dentro());
        assertNotEquals(expectedDto.get_zonas_seguras(), resultDto.get_zonas_seguras());
        assertNotEquals(expectedDto.get_latitud(), resultDto.get_latitud());
        assertNotEquals(expectedDto.get_longitud(), resultDto.get_longitud());
    }

    @Test
    public void testCalculateCoordinatesInArea() {
        // Arrange
        Double personLatitude = 10.0;
        Double personLongitude = 20.0;
        Double[] areaLatitudes = {10.0, 20.0, 30.0};
        Double[] areaLongitudes = {20.0, 30.0, 40.0};

        // Act
        boolean result = determinarAtacanteZonaSegura.calculateCoordinatesInArea(personLatitude, personLongitude, areaLatitudes, areaLongitudes);

        // Assert
        assertFalse(result);
    }
}
