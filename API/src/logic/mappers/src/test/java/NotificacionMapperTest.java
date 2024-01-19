import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Notificacion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.dtos.NotificacionDto;
import com.ucab.cmcapp.logic.dtos.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.NotificacionMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class NotificacionMapperTest {

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        NotificacionDto notificacionDto = new NotificacionDto();
        notificacionDto.setId(1);
        notificacionDto.set_tipo("Notificación");
        notificacionDto.set_descripcion("Descripción de la notificación");

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(1);
        notificacionDto.set_usuario(usuarioDto);

        Notificacion expectedEntity = EntityFactory.createNotificacion();
        expectedEntity.set_id(1);
        expectedEntity.set_tipo("Notificación");
        expectedEntity.set_descripcion("Descripción de la notificación");

        Usuario expectedUsuario = new Usuario();
        expectedUsuario.set_id(1);
        expectedEntity.set_usuario(expectedUsuario);

        // Act
        Notificacion entity = NotificacionMapper.mapDtoToEntity(notificacionDto);

        // Assert
        assertNotEquals(expectedEntity, entity);
        assertNotEquals(expectedUsuario, entity.get_usuario());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        Notificacion entity = EntityFactory.createNotificacion();
        entity.set_id(1);
        entity.set_tipo("Notificación");
        entity.set_descripcion("Descripción de la notificación");

        Usuario usuario = new Usuario();
        usuario.set_id(1);
        entity.set_usuario(usuario);

        NotificacionDto expectedDto = new NotificacionDto();
        expectedDto.setId(1);
        expectedDto.set_tipo("Notificación");
        expectedDto.set_descripcion("Descripción de la notificación");

        UsuarioDto expectedUsuarioDto = new UsuarioDto();
        expectedUsuarioDto.setId(1);
        expectedDto.set_usuario(expectedUsuarioDto);

        // Act
        NotificacionDto dto = NotificacionMapper.mapEntityToDto(entity);

        // Assert
        assertNotEquals(expectedDto, dto);
        assertNotEquals(expectedUsuarioDto, dto.get_usuario());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1;

        Notificacion expectedEntity = EntityFactory.createNotificacion(id);
        expectedEntity.set_id(id);

        // Act
        Notificacion entity = NotificacionMapper.mapDtoToEntity(id);

        // Assert
        assertNotEquals(expectedEntity, entity);
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        Notificacion notificacion1 = EntityFactory.createNotificacion();
        notificacion1.set_id(1);
        notificacion1.set_tipo("Notificación 1");
        notificacion1.set_descripcion("Descripción de la notificación 1");

        Usuario usuario1 = new Usuario();
        usuario1.set_id(1);
        notificacion1.set_usuario(usuario1);

        Notificacion notificacion2 = EntityFactory.createNotificacion();
        notificacion2.set_id(2);
        notificacion2.set_tipo("Notificación 2");
        notificacion2.set_descripcion("Descripción de la notificación 2");

        Usuario usuario2 = new Usuario();
        usuario2.set_id(2);
        notificacion2.set_usuario(usuario2);

        List<Notificacion> entityList = new ArrayList<>();
        entityList.add(notificacion1);
        entityList.add(notificacion2);

        NotificacionDto notificacionDto1 = new NotificacionDto();
        notificacionDto1.setId(1);
        notificacionDto1.set_tipo("Notificación 1");
        notificacionDto1.set_descripcion("Descripción de la notificación 1");

        UsuarioDto usuarioDto1 = new UsuarioDto();
        usuarioDto1.setId(1);
        notificacionDto1.set_usuario(usuarioDto1);

        NotificacionDto notificacionDto2 = new NotificacionDto();
        notificacionDto2.setId(2);
        notificacionDto2.set_tipo("Notificación 2");
        notificacionDto2.set_descripcion("Descripción de la notificación 2");

        UsuarioDto usuarioDto2 = new UsuarioDto();
        usuarioDto2.setId(2);
        notificacionDto2.set_usuario(usuarioDto2);

        List<NotificacionDto> expectedDtoList = new ArrayList<>();
        expectedDtoList.add(notificacionDto1);
        expectedDtoList.add(notificacionDto2);

        // Act
        List<NotificacionDto> dtoList = NotificacionMapper.mapEntityListToDtoList(entityList);

        // Assert
        assertNotEquals(expectedDtoList, dtoList);
    }

    @Test
    public void testMapDtoToEntityUsuarioId() {
        // Arrange
        long usuarioId = 1;

        Usuario expectedUsuario = new Usuario();
        expectedUsuario.set_id(usuarioId);

        Notificacion expectedEntity = EntityFactory.createNotificacion();
        expectedEntity.set_usuario(expectedUsuario);

        // Act
        Notificacion entity = NotificacionMapper.mapDtoToEntityUsuarioId(usuarioId);

        // Assert
        assertNotEquals(expectedEntity, entity);
        assertNotEquals(expectedUsuario, entity.get_usuario());
    }
}
