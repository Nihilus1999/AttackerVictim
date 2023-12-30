import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UsuarioMapperTest {

    private UsuarioDto dto;
    private Usuario entity;

    @BeforeEach
    public void setup() {
        dto = new UsuarioDto();
        entity = new Usuario();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_nombre("John");
        dto.set_apellido("Doe");
        dto.set_alias("johndoe");
        dto.set_cedula("123456789");
        dto.set_correo("johndoe@example.com");
        dto.set_direccion_mac("00:00:00:00:00:00");
        dto.set_clave("password");
        dto.set_activate(false);

        // Act
        Usuario result = UsuarioMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getId(), result.get_id());
        Assertions.assertEquals(dto.get_nombre(), result.get_nombre());
        Assertions.assertEquals(dto.get_apellido(), result.get_apellido());
        Assertions.assertEquals(dto.get_alias(), result.get_alias());
        Assertions.assertEquals(dto.get_cedula(), result.get_cedula());
        Assertions.assertEquals(dto.get_correo(), result.get_correo());
        Assertions.assertEquals(dto.get_direccion_mac(), result.get_direccion_mac());
        Assertions.assertEquals(dto.get_clave(), result.get_clave());
        Assertions.assertEquals(dto.get_activate(), result.get_activate());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        entity.set_id(1L);
        entity.set_nombre("John");
        entity.set_apellido("Doe");
        entity.set_alias("johndoe");
        entity.set_cedula("123456789");
        entity.set_correo("johndoe@example.com");
        entity.set_direccion_mac("00:00:00:00:00:00");
        entity.set_clave("password");
        entity.set_activate(false);

        // Act
        UsuarioDto result = UsuarioMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(entity.get_id(), result.getId());
        Assertions.assertEquals(entity.get_nombre(), result.get_nombre());
        Assertions.assertEquals(entity.get_apellido(), result.get_apellido());
        Assertions.assertEquals(entity.get_alias(), result.get_alias());
        Assertions.assertEquals(entity.get_cedula(), result.get_cedula());
        Assertions.assertEquals(entity.get_correo(), result.get_correo());
        Assertions.assertEquals(entity.get_direccion_mac(), result.get_direccion_mac());
        Assertions.assertEquals(entity.get_clave(), result.get_clave());
        Assertions.assertEquals(entity.get_activate(), result.get_activate());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1L;

        // Act
        Usuario result = UsuarioMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Usuario> entityList = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.set_id(1L);
        usuario.set_nombre("John");
        usuario.set_apellido("Doe");
        usuario.set_alias("johndoe");
        usuario.set_cedula("123456789");
        usuario.set_correo("johndoe@example.com");
        usuario.set_direccion_mac("00:00:00:00:00:00");
        usuario.set_clave("password");
        usuario.set_activate(false);
        entityList.add(usuario);

        // Act
        List<UsuarioDto> dtoList = UsuarioMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());

        UsuarioDto resultDto = dtoList.get(0);
        Assertions.assertEquals(usuario.get_id(), resultDto.getId());
        Assertions.assertEquals(usuario.get_nombre(), resultDto.get_nombre());
        Assertions.assertEquals(usuario.get_apellido(), resultDto.get_apellido());
        Assertions.assertEquals(usuario.get_alias(), resultDto.get_alias());
        Assertions.assertEquals(usuario.get_cedula(), resultDto.get_cedula());
        Assertions.assertEquals(usuario.get_correo(), resultDto.get_correo());
        Assertions.assertEquals(usuario.get_direccion_mac(), resultDto.get_direccion_mac());
        Assertions.assertEquals(usuario.get_clave(), resultDto.get_clave());
        Assertions.assertEquals(usuario.get_activate(), resultDto.get_activate());
    }

    @Test
    public void testMapDtoToEntityCorreo() {
        // Arrange
        String email = "test@example.com";

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityCorreo(email);

        // Assert
        assertNotNull(entity);
        assertEquals(email, entity.get_correo());
    }

    @Test
    public void testMapDtoToEntityAlias() {
        // Arrange
        String alias = "test_alias";

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityAlias(alias);

        // Assert
        assertNotNull(entity);
        assertEquals(alias, entity.get_alias());
    }

    @Test
    public void testMapDtoToEntityCedula() {
        // Arrange
        String cedula = "1234567890";

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityCedula(cedula);

        // Assert
        assertNotNull(entity);
        assertEquals(cedula, entity.get_cedula());
    }

    @Test
    public void testMapDtoToEntityMac() {
        // Arrange
        String mac = "00:11:22:33:44:55";

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityMac(mac);

        // Assert
        assertNotNull(entity);
        assertEquals(mac, entity.get_direccion_mac());
    }

}