import com.ucab.cmcapp.common.entities.Usuario_Atacante;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_AtacanteDto;
import com.ucab.cmcapp.logic.mappers.Usuario_AtacanteMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Usuario_AtacanteMapperTest {

    private Usuario_AtacanteDto dto;
    private Usuario_Atacante entity;

    @BeforeEach
    public void setup() {
        dto = new Usuario_AtacanteDto();
        entity = new Usuario_Atacante();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);

        // Act
        Usuario_Atacante result = Usuario_AtacanteMapper.mapDtoToEntity(dto);

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
        Usuario_AtacanteDto result = Usuario_AtacanteMapper.mapEntityToDto(entity);

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
        Usuario_Atacante result = Usuario_AtacanteMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Usuario_Atacante> entityList = new ArrayList<>();
        Usuario_Atacante atacanteUsuario = new Usuario_Atacante();
        atacanteUsuario.set_id(1L);
        entityList.add(atacanteUsuario);

        // Act
        List<Usuario_AtacanteDto> dtoList = Usuario_AtacanteMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());

        Usuario_AtacanteDto resultDto = dtoList.get(0);
        Assertions.assertEquals(atacanteUsuario.get_id(), resultDto.getId());
        // Verificar que se llame al mapper correspondiente
        Assertions.assertNull(resultDto.get_usuario());
    }
}
