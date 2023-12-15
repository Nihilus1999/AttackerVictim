import com.ucab.cmcapp.common.util.CustomResponse;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomResponseTest {

    @Test
    public void testCustomResponseWithResponse() {
        // Arrange
        String expectedResponse = "Test response";
        String expectedDescription = "Test description";

        // Act
        CustomResponse<String> customResponse = new CustomResponse<>(expectedResponse, expectedDescription);

        // Assert
        assertEquals(expectedResponse, customResponse.response);
        assertEquals(expectedDescription, customResponse.description);
    }

    @Test
    public void testCustomResponseWithoutResponse() {
        // Arrange
        String expectedDescription = "Test description";

        // Act
        CustomResponse<String> customResponse = new CustomResponse<>(expectedDescription);

        // Assert
        assertNull(customResponse.response);
        assertEquals(expectedDescription, customResponse.description);
    }
}
