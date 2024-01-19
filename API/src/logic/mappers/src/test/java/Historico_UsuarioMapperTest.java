import com.ucab.cmcapp.common.entities.Historico_Usuario;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.mappers.Historico_UsuarioMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Historico_UsuarioMapperTest {


    public static Date convertStringToDate(String dateString) throws ParseException {
        String defaultPattern = "yyyy-MM-dd"; // Patrón predeterminado
        SimpleDateFormat sdf = new SimpleDateFormat(defaultPattern);
        return sdf.parse(dateString);
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        Historico_UsuarioDto dto = new Historico_UsuarioDto();
        dto.setId(1);
        dto.set_fecha(convertStringToDate("2023-10-31"));
        dto.set_estadoConexion(true);
        dto.set_latitud(37.7749);
        dto.set_longitud(-122.4194);

        // Act
        Historico_Usuario entity = Historico_UsuarioMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.get_id());
        Assertions.assertEquals(dto.get_fecha(), entity.get_fecha());
        Assertions.assertEquals(dto.get_estadoConexion(), entity.get_estadoConexion());
        Assertions.assertEquals(dto.get_latitud(), entity.get_latitud());
        Assertions.assertEquals(dto.get_longitud(), entity.get_longitud());
    }

    @Test
    public void testMapEntityToDto() throws ParseException {
        // Arrange
        Historico_Usuario entity = new Historico_Usuario();
        entity.set_id(1);
        entity.set_fecha(convertStringToDate("2023-10-31"));
        entity.set_estadoConexion(true);
        entity.set_latitud(37.7749);
        entity.set_longitud(-122.4194);

        // Act
        Historico_UsuarioDto dto = Historico_UsuarioMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.get_id(), dto.getId());
        Assertions.assertEquals(entity.get_fecha(), dto.get_fecha());
        Assertions.assertEquals(entity.get_estadoConexion(), dto.get_estadoConexion());
        Assertions.assertEquals(entity.get_latitud(), dto.get_latitud());
        Assertions.assertEquals(entity.get_longitud(), dto.get_longitud());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1;

        // Act
        Historico_Usuario entity = Historico_UsuarioMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() throws ParseException {
        // Arrange
        List<Historico_Usuario> entityList = new ArrayList<>();
        Historico_Usuario entity1 = new Historico_Usuario();
        entity1.set_id(1);
        entity1.set_fecha(convertStringToDate("2023-10-31"));
        entity1.set_estadoConexion(true);
        entity1.set_latitud(37.7749);
        entity1.set_longitud(-122.4194);
        Historico_Usuario entity2 = new Historico_Usuario();
        entity2.set_id(2);
        entity2.set_fecha(convertStringToDate("2023-10-31"));
        entity2.set_estadoConexion(false);
        entity2.set_latitud(34.0522);
        entity2.set_longitud(-118.2437);
        entityList.add(entity1);
        entityList.add(entity2);

        // Act
        List<Historico_UsuarioDto> dtoList = Historico_UsuarioMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Historico_Usuario entity = entityList.get(i);
            Historico_UsuarioDto dto = dtoList.get(i);
            Assertions.assertEquals(entity.get_id(), dto.getId());
            Assertions.assertEquals(entity.get_fecha(), dto.get_fecha());
            Assertions.assertEquals(entity.get_estadoConexion(), dto.get_estadoConexion());
            Assertions.assertEquals(entity.get_latitud(), dto.get_latitud());
            Assertions.assertEquals(entity.get_longitud(), dto.get_longitud());
        }
    }

    @Test
    public void testMapDtoToEntityUsuarioId() {
        // Arrange
        long usuarioId = 1;

        // Act
        Historico_Usuario entity = Historico_UsuarioMapper.mapDtoToEntityUsuarioId(usuarioId);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(usuarioId, entity.get_usuario().get_id());
    }
}