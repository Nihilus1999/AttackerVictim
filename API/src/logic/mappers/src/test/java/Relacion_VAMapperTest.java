import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.logic.dtos.dtos.Relacion_VADto;
import com.ucab.cmcapp.logic.mappers.Relacion_VAMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Relacion_VAMapperTest {

    private Relacion_VADto dto;
    private Relacion_VA entity;

    @BeforeEach
    public void setup() {
        dto = new Relacion_VADto();
        entity = new Relacion_VA();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_distancia(10);

        // Act
        Relacion_VA result = Relacion_VAMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getId(), result.get_id());
        Assertions.assertEquals(dto.get_distancia(), result.get_distancia());
        // Verificar que se llame a los mappers correspondientes
        Assertions.assertNull(result.get_usuario_victima());
        Assertions.assertNull(result.get_usuario_atacante());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        entity.set_id(1L);
        entity.set_distancia(10);

        // Act
        Relacion_VADto result = Relacion_VAMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(entity.get_id(), result.getId());
        Assertions.assertEquals(entity.get_distancia(), result.get_distancia());
        // Verificar que se llame a los mappers correspondientes
        Assertions.assertNull(result.get_usuario_victima());
        Assertions.assertNull(result.get_usuario_atacante());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1L;

        // Act
        Relacion_VA result = Relacion_VAMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Relacion_VA> entityList = new ArrayList<>();
        Relacion_VA relacionUsuario = new Relacion_VA();
        relacionUsuario.set_id(1L);
        relacionUsuario.set_distancia(10);
        entityList.add(relacionUsuario);

        // Act
        List<Relacion_VADto> dtoList = Relacion_VAMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());

        Relacion_VADto resultDto = dtoList.get(0);
        Assertions.assertEquals(relacionUsuario.get_id(), resultDto.getId());
        Assertions.assertEquals(relacionUsuario.get_distancia(), resultDto.get_distancia());
        // Verificar que se llame a los mappers correspondientes
        Assertions.assertNull(resultDto.get_usuario_victima());
        Assertions.assertNull(resultDto.get_usuario_atacante());
    }
}
