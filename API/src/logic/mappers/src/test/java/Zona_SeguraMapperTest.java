import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import com.ucab.cmcapp.logic.mappers.Zona_SeguraMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zona_SeguraMapperTest {

    private Zona_SeguraDto dto;
    private Zona_Segura entity;

    @BeforeEach
    public void setup() {
        dto = new Zona_SeguraDto();
        entity = new Zona_Segura();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_nombre("Zona Segura 1");

        Usuario_VictimaDto victimaDto = new Usuario_VictimaDto();
        victimaDto.setId(1L);
        dto.set_victima(victimaDto);

        // Act
        Zona_Segura result = Zona_SeguraMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getId(), result.get_id());
        Assertions.assertEquals(dto.get_nombre(), result.get_nombre());
        Assertions.assertNotNull(result.get_victima());
        Assertions.assertEquals(dto.get_victima().getId(), result.get_victima().get_id());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        entity.set_id(1L);
        entity.set_nombre("Zona Segura 1");

        Usuario_Victima victima = new Usuario_Victima();
        victima.set_id(1L);
        entity.set_victima(victima);

        // Act
        Zona_SeguraDto result = Zona_SeguraMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(entity.get_id(), result.getId());
        Assertions.assertEquals(entity.get_nombre(), result.get_nombre());
        Assertions.assertNotNull(result.get_victima());
        Assertions.assertEquals(entity.get_victima().get_id(), result.get_victima().getId());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1L;

        // Act
        Zona_Segura result = Zona_SeguraMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Zona_Segura> entityList = new ArrayList<>();
        Zona_Segura zonaSegura = new Zona_Segura();
        zonaSegura.set_id(1L);
        zonaSegura.set_nombre("Zona Segura 1");

        Usuario_Victima victima = new Usuario_Victima();
        victima.set_id(1L);
        zonaSegura.set_victima(victima);

        entityList.add(zonaSegura);

        // Act
        List<Zona_SeguraDto> dtoList = Zona_SeguraMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());

        Zona_SeguraDto resultDto = dtoList.get(0);
        Assertions.assertEquals(zonaSegura.get_id(), resultDto.getId());
        Assertions.assertEquals(zonaSegura.get_nombre(), resultDto.get_nombre());
        Assertions.assertNotNull(resultDto.get_victima());
        Assertions.assertEquals(zonaSegura.get_victima().get_id(), resultDto.get_victima().getId());
    }

    @Test
    public void testMapDtoToEntityUsuarioId() {
        // Arrange
        long usuarioId = 1L;

        // Act
        Zona_Segura result = Zona_SeguraMapper.mapDtoToEntityUsuarioId(usuarioId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.get_id());
        Assertions.assertNull(result.get_nombre());
        Assertions.assertNotNull(result.get_victima());
        Assertions.assertEquals(usuarioId, result.get_victima().get_id());
    }
}
