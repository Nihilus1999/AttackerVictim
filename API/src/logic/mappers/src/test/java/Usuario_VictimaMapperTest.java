import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import com.ucab.cmcapp.logic.mappers.Usuario_VictimaMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario_VictimaMapperTest {

    private Usuario_VictimaDto dto;
    private Usuario_Victima entity;

    @BeforeEach
    public void setup() {
        dto = new Usuario_VictimaDto();
        entity = new Usuario_Victima();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);

        // Act
        Usuario_Victima result = Usuario_VictimaMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getId(), result.get_id());
        // Verificar que se llame al mapper correspondiente
        Assertions.assertNull(result.get_usuario());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        entity.set_id(1L);

        // Act
        Usuario_VictimaDto result = Usuario_VictimaMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(entity.get_id(), result.getId());
        // Verificar que se llame al mapper correspondiente
        Assertions.assertNull(result.get_usuario());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1L;

        // Act
        Usuario_Victima result = Usuario_VictimaMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Usuario_Victima> entityList = new ArrayList<>();
        Usuario_Victima victimaUsuario = new Usuario_Victima();
        victimaUsuario.set_id(1L);
        entityList.add(victimaUsuario);

        // Act
        List<Usuario_VictimaDto> dtoList = Usuario_VictimaMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());

        Usuario_VictimaDto resultDto = dtoList.get(0);
        Assertions.assertEquals(victimaUsuario.get_id(), resultDto.getId());
        // Verificar que se llame al mapper correspondiente
        Assertions.assertNull(resultDto.get_usuario());
    }
}
