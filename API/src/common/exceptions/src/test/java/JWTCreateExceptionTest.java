

import com.ucab.cmcapp.common.exceptions.JWTCreateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTCreateExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String message = "Test Exception";

        // Act
        JWTCreateException exception = new JWTCreateException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}