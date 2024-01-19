import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadaMapperTest {

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        CoordenadaDto dto = new CoordenadaDto();
        dto.setId(1);
        dto.set_latitud(37.7749);
        dto.set_longitud(-122.4194);

        // Act
        Coordenada entity = CoordenadaMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.get_id());
        Assertions.assertEquals(dto.get_latitud(), entity.get_latitud());
        Assertions.assertEquals(dto.get_longitud(), entity.get_longitud());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        Coordenada entity = new Coordenada();
        entity.set_id(1);
        entity.set_latitud(37.7749);
        entity.set_longitud(-122.4194);

        // Act
        CoordenadaDto dto = CoordenadaMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.get_id(), dto.getId());
        Assertions.assertEquals(entity.get_latitud(), dto.get_latitud());
        Assertions.assertEquals(entity.get_longitud(), dto.get_longitud());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1;

        // Act
        Coordenada entity = CoordenadaMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Coordenada> entityList = new ArrayList<>();
        Coordenada entity1 = new Coordenada();
        entity1.set_id(1);
        entity1.set_latitud(37.7749);
        entity1.set_longitud(-122.4194);
        Coordenada entity2 = new Coordenada();
        entity2.set_id(2);
        entity2.set_latitud(34.0522);
        entity2.set_longitud(-118.2437);
        entityList.add(entity1);
        entityList.add(entity2);

        // Act
        List<CoordenadaDto> dtoList = CoordenadaMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Coordenada entity = entityList.get(i);
            CoordenadaDto dto = dtoList.get(i);
            Assertions.assertEquals(entity.get_id(), dto.getId());
            Assertions.assertEquals(entity.get_latitud(), dto.get_latitud());
            Assertions.assertEquals(entity.get_longitud(), dto.get_longitud());
        }
    }

    @Test
    public void testMapDtoToEntityZonaId() {
        // Arrange
        long zonaId = 1;

        // Act
        Coordenada entity = CoordenadaMapper.mapDtoToEntityZonaId(zonaId);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(zonaId, entity.get_zona_segura().get_id());
    }
}
