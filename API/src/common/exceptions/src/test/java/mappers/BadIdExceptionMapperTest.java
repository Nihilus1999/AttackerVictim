package mappers;

import com.ucab.cmcapp.common.exceptions.BadIdException;
import com.ucab.cmcapp.common.exceptions.FaultBean;
import com.ucab.cmcapp.common.exceptions.mappers.BadIdExceptionMapper;
import com.ucab.cmcapp.properties.Registry;

import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BadIdExceptionMapperTest {

    @Test
    public void testToResponse() {
        BadIdException exception = new BadIdException("Invalid ID");
        Registry registryMock = mock(Registry.class);
        when(registryMock.getProperty(anyString())).thenReturn("500");

        BadIdExceptionMapper mapper = new BadIdExceptionMapper();
        Response response = mapper.toResponse(exception);
        FaultBean faultBean = (FaultBean) response.getEntity();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
        assertEquals("500", faultBean.getCode());
        assertEquals("500", faultBean.getMessage());

        // Verificar que se llamó al método getProperty del registryMock
        verify(registryMock, times(2)).getProperty(anyString());
    }
}
