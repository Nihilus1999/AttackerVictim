
import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Administrador;
import com.ucab.cmcapp.logic.dtos.dtos.AdministradorDto;
import com.ucab.cmcapp.logic.mappers.AdministradorMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdministradorMapperTest {

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        AdministradorDto dto = new AdministradorDto();
        dto.setId(1);
        dto.set_alias("admin");
        dto.set_correo("admin@example.com");
        dto.set_clave("password");

        // Act
        Administrador entity = AdministradorMapper.mapDtoToEntity(dto);

        // Assert
        assertEquals(dto.getId(), entity.get_id());
        assertEquals(dto.get_alias(), entity.get_alias());
        assertEquals(dto.get_correo(), entity.get_correo());
        assertEquals(dto.get_clave(), entity.get_clave());
    }

    @Test
    public void testMapDtoToEntityotro() {
        // Arrange
        long id = 1;

        // Act
        Administrador entity = AdministradorMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_id());

        // Verificar que se haya llamado a EntityFactory.createAdministrador con el id correcto
        EntityFactory entityFactoryMock = Mockito.mock(EntityFactory.class);
        Administrador expectedEntity = EntityFactory.createAdministrador(id);
        Mockito.verify(entityFactoryMock, Mockito.times(1)).createAdministrador(id);
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        Administrador entity = new Administrador();
        entity.set_id(1);
        entity.set_alias("admin");
        entity.set_correo("admin@example.com");
        entity.set_clave("password");

        // Act
        AdministradorDto dto = AdministradorMapper.mapEntityToDto(entity);

        // Assert
        assertEquals(entity.get_id(), dto.getId());
        assertEquals(entity.get_alias(), dto.get_alias());
        assertEquals(entity.get_correo(), dto.get_correo());
        assertEquals(entity.get_clave(), dto.get_clave());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Administrador> entityList = new ArrayList<>();
        Administrador entity1 = new Administrador();
        entity1.set_id(1);
        entity1.set_alias("admin1");
        entity1.set_correo("admin1@example.com");
        entity1.set_clave("password1");
        entityList.add(entity1);
        Administrador entity2 = new Administrador();
        entity2.set_id(2);
        entity2.set_alias("admin2");
        entity2.set_correo("admin2@example.com");
        entity2.set_clave("password2");
        entityList.add(entity2);

        // Act
        List<AdministradorDto> dtoList = AdministradorMapper.mapEntityListToDtoList(entityList);

        // Assert
        assertEquals(entityList.size(), dtoList.size());
        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_alias(), dtoList.get(0).get_alias());
        assertEquals(entityList.get(0).get_correo(), dtoList.get(0).get_correo());
        assertEquals(entityList.get(0).get_clave(), dtoList.get(0).get_clave());
        assertEquals(entityList.get(1).get_id(), dtoList.get(1).getId());
        assertEquals(entityList.get(1).get_alias(), dtoList.get(1).get_alias());
        assertEquals(entityList.get(1).get_correo(), dtoList.get(1).get_correo());
        assertEquals(entityList.get(1).get_clave(), dtoList.get(1).get_clave());
    }

    @Test
    public void testMapDtoToEntityCorreo() {
        // Arrange
        String email = "admin@example.com";

        // Act
        Administrador entity = AdministradorMapper.mapDtoToEntityCorreo(email);

        // Assert
        assertEquals(email, entity.get_correo());
    }

    @Test
    public void testMapDtoToEntityAlias() {
        // Arrange
        String alias = "admin";

        // Act
        Administrador entity = AdministradorMapper.mapDtoToEntityAlias(alias);

        // Assert
        assertEquals(alias, entity.get_alias());
    }
}