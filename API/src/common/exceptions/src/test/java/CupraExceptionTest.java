

import com.ucab.cmcapp.common.exceptions.CupraException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CupraExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        CupraException exception = new CupraException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}