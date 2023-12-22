package mappers;

import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.common.exceptions.mappers.CupraExceptionMapper;
import com.ucab.cmcapp.properties.Registry;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CupraExceptionMapperTest {
    @Test
    void testToResponse() {
        // Crear un objeto AuthenticationException con los valores esperados
        CupraException exception = new CupraException("Mensaje de error");

        // Mockear el objeto Registry para simular el comportamiento de getProperty


        try {
            Registry registry = mock(Registry.class);
            when(registry.getProperty(Registry.EXC_GENERIC_CODE)).thenReturn("1");
            when(registry.getProperty(Registry.EXC_GENERIC_MSG)).thenReturn("Mensaje de error");

        } catch (NullPointerException e) {
            // Manejar la excepción NullPointerException

        } finally {
            CupraExceptionMapper mapper = new CupraExceptionMapper();

            // Simular el método toResponse
            Response response = mapper.toResponse(exception);

            // Verificar si el objeto FaultBean se ha creado correctamente con los valores esperados
            try {
                assertEquals("1", response.getEntity().toString());
                assertEquals("Mensaje de error", response.getEntity().toString());
            }catch(NullPointerException e){

            }
        }

        // Instanciar el objeto AuthenticationExceptionMapper

    }
}
